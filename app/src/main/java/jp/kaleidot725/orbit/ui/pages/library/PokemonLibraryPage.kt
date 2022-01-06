package jp.kaleidot725.orbit.ui.pages.library

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.ui.atoms.ImageCard
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
                        ImageCard(
                            title = details.pokemon.name,
                            imageUrl = details.pokemon.img,
                            modifier = Modifier
                                .size(150.dp)
                                .padding(4.dp)
                        )
                    }
                }
            }
        }
    }
}