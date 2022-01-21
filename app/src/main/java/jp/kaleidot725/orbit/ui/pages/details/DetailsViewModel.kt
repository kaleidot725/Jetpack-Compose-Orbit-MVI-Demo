package jp.kaleidot725.orbit.ui.pages.details

import androidx.lifecycle.ViewModel
import jp.kaleidot725.orbit.domain.usecase.LoadPokemonDetailsUseCase
import jp.kaleidot725.orbit.ui.common.UiStatus
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class DetailsViewModel(
    private val id: Int,
    private val loadPokemonDetailsUseCase: LoadPokemonDetailsUseCase
) : ContainerHost<DetailsState, DetailsSideEffect>, ViewModel() {
    override val container = container<DetailsState, DetailsSideEffect>(
        DetailsState()
    )

    init {
        intent {
            val details = loadPokemonDetailsUseCase(id)
            if (details != null) {
                reduce { state.copy(status = UiStatus.Success, details = details) }
            } else {
                reduce { state.copy(status = UiStatus.Failed("Loading Error."), details = null) }
            }
        }
    }
}