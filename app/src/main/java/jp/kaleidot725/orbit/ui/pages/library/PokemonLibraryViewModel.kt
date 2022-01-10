package jp.kaleidot725.orbit.ui.pages.library

import androidx.lifecycle.ViewModel
import jp.kaleidot725.orbit.domain.usecase.FetchAllPokemonUseCase
import jp.kaleidot725.orbit.domain.usecase.LoadAllPokemonUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class PokemonLibraryViewModel(
    private val fetchAllPokemonUseCase: FetchAllPokemonUseCase,
    private val loadAllPokemonUseCase: LoadAllPokemonUseCase
) : ContainerHost<PokemonLibraryState, PokemonLibrarySideEffect>, ViewModel() {
    override val container = container<PokemonLibraryState, PokemonLibrarySideEffect>(
        PokemonLibraryState()
    )

    init {
        intent {
            fetchAllPokemonUseCase()
            val details = loadAllPokemonUseCase()
            reduce { state.copy(details = details) }
        }
    }
}