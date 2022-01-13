package jp.kaleidot725.orbit.ui.pages.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.kaleidot725.orbit.domain.usecase.FetchAllPokemonUseCase
import jp.kaleidot725.orbit.domain.usecase.SearchPokemonUseCase
import jp.kaleidot725.orbit.ui.common.UiStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class PokemonLibraryViewModel(
    private val fetchAllPokemonUseCase: FetchAllPokemonUseCase,
    private val searchPokemonUseCase: SearchPokemonUseCase
) : ContainerHost<PokemonLibraryState, PokemonLibrarySideEffect>, ViewModel() {
    private var searchJob: Job? = null

    override val container = container<PokemonLibraryState, PokemonLibrarySideEffect>(
        PokemonLibraryState()
    )

    init {
        intent {
            search(state.searchText)
        }
    }

    fun search(searchText: String) {
        intent {
            searchJob?.cancel()
            searchJob = viewModelScope.launch(Dispatchers.IO) {
                reduce {
                    state.copy(
                        status = UiStatus.Loading,
                        searchText = searchText,
                        details = emptyList()
                    )
                }

                val details = searchPokemonUseCase(state.searchText)
                delay(1000)

                if (details.isNotEmpty()) {
                    reduce {
                        state.copy(
                            status = UiStatus.Success,
                            details = details
                        )
                    }
                } else {
                    reduce {
                        state.copy(
                            status = UiStatus.Failed("Not Found"),
                            details = details
                        )
                    }
                }
            }
        }
    }
}