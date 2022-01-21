package jp.kaleidot725.orbit.ui.pages.details

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class DetailsViewModel : ContainerHost<DetailsState, DetailsSideEffect>, ViewModel() {
    override val container = container<DetailsState, DetailsSideEffect>(
        DetailsState()
    )
}