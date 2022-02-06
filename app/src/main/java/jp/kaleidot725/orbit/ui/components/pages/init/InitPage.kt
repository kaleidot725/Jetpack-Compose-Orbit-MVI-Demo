package jp.kaleidot725.orbit.ui.components.pages.init

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import jp.kaleidot725.orbit.ui.common.UiStatus
import jp.kaleidot725.orbit.ui.components.organisms.DownloadRetryMessage
import jp.kaleidot725.orbit.ui.components.organisms.DownloadingMessage
import kotlinx.coroutines.flow.collect

@Composable
fun InitPage(
    viewModel: InitViewModel,
    onCompleted: () -> Unit
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect {
            when (it) {
                is InitSideEffect.Completed -> onCompleted()
            }
        }
    }

    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            when (state.status) {
                UiStatus.Loading -> {
                    DownloadingMessage(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center)
                    )
                }
                is UiStatus.Failed -> {
                    DownloadRetryMessage(
                        onRetry = { viewModel.retry() },
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.Center)
                    )
                }
                UiStatus.Success -> Unit
            }
        }
    }
}
