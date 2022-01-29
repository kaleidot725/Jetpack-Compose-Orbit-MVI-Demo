package jp.kaleidot725.orbit.ui.pages.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import jp.kaleidot725.orbit.ui.molecules.PokemonPortrait
import jp.kaleidot725.orbit.ui.organisms.PokemonFigure
import jp.kaleidot725.orbit.ui.organisms.PokemonRevolutions
import jp.kaleidot725.orbit.ui.organisms.PokemonTypes
import jp.kaleidot725.orbit.ui.organisms.PokemonWeaknesses
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
                    state.details?.let { details ->
                        LazyColumn {
                            item {
                                PokemonPortrait(
                                    pokemonDetails = details,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp)
                                )
                            }

                            item {
                                PokemonTypes(
                                    types = details.types.map { it.value },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .padding(horizontal = 16.dp)
                                        .padding(vertical = 8.dp)
                                )
                            }

                            item {
                                PokemonWeaknesses(
                                    weaknesses = details.weaknesses.map { it.value },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .padding(horizontal = 16.dp)
                                        .padding(vertical = 8.dp)
                                )
                            }

                            item {
                                PokemonFigure(
                                    pokemonEntity = details.pokemon,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .padding(horizontal = 16.dp)
                                        .padding(vertical = 8.dp)
                                )
                            }

                            item {
                                PokemonRevolutions(
                                    details = state.revolutions,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .padding(horizontal = 16.dp)
                                        .padding(vertical = 8.dp)
                                )
                            }

                        }
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