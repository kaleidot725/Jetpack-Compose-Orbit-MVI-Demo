package jp.kaleidot725.orbit.ui.page.library

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.collect

@Composable
fun PokemonLibraryPage(viewModel: PokemonLibraryViewModel) {
    val state = viewModel.container.stateFlow.collectAsState().value

    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect { /** Do Nothing */ }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Box {
            LazyColumn(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                state.details.forEach { details ->
                    item {
                        Text(text = details.pokemon.name)
                    }
                }
            }
        }
    }
}