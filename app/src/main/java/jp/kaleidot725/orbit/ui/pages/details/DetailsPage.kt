package jp.kaleidot725.orbit.ui.pages.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.ui.common.UiStatus
import jp.kaleidot725.orbit.ui.molecules.BackButton
import jp.kaleidot725.orbit.ui.molecules.ErrorMessage
import jp.kaleidot725.orbit.ui.molecules.LoadingIndicator
import jp.kaleidot725.orbit.ui.organisms.PokemonDetails
import kotlinx.coroutines.flow.collect

@Composable
fun DetailsPage(
    viewModel: DetailsViewModel,
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

    Scaffold {
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
                Box(modifier = Modifier.fillMaxSize()) {
                    state.details?.let {
                        PokemonDetails(
                            details = it,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    BackButton(
                        onClick = { onBack.invoke() },
                        modifier = Modifier
                            .size(48.dp)
                            .padding(top = 12.dp, start = 12.dp)
                            .align(Alignment.TopStart)
                    )
                }
            }
        }
    }
}