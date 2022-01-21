package jp.kaleidot725.orbit.ui.pages.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
    }
}