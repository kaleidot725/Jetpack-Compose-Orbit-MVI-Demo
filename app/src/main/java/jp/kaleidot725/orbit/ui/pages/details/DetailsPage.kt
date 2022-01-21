package jp.kaleidot725.orbit.ui.pages.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import jp.kaleidot725.orbit.ui.common.UiStatus
import jp.kaleidot725.orbit.ui.molecules.ErrorMessage
import jp.kaleidot725.orbit.ui.molecules.LoadingIndicator
import jp.kaleidot725.orbit.ui.organisms.PokemonDetails
import kotlinx.coroutines.flow.collect

@Composable
fun DetailsPage(
    viewModel: DetailsViewModel,
    id: Int,
    onBack: () -> Unit
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect {
            when (it) {
                is DetailsSideEffect.Back -> onBack()
            }
        }
    }

    LaunchedEffect(id) {
        viewModel.load(id)
    }

    when (state.status) {
        UiStatus.Loading -> {
            LoadingIndicator(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        is UiStatus.Failed -> {
            ErrorMessage(
                message = state.status.message,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        UiStatus.Success -> {
            state.details?.let {
                PokemonDetails(
                    details = it,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}