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
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.common.UiStatus
import jp.kaleidot725.orbit.ui.molecules.BackButton
import jp.kaleidot725.orbit.ui.molecules.ErrorMessage
import jp.kaleidot725.orbit.ui.molecules.LoadingIndicator
import jp.kaleidot725.orbit.ui.molecules.PokemonPortrait
import jp.kaleidot725.orbit.ui.organisms.PokemonBreeding
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
                val details = state.details ?: return@Scaffold
                val revolutions = state.revolutions

                Box(modifier = Modifier.fillMaxSize()) {
                    PokemonDataList(
                        details = details,
                        revolutions = revolutions,
                        modifier = Modifier.fillMaxSize()
                    )

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

@Composable
private fun PokemonDataList(
    details: PokemonDetails,
    revolutions: List<PokemonDetails>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        item {
            PokemonPortrait(
                pokemonDetails = details,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }

        item {
            PokemonTypes(
                details = details,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            PokemonWeaknesses(
                details = details,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            PokemonBreeding(
                pokemonEntity = details.pokemon,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            PokemonRevolutions(
                details = revolutions,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            )
        }
    }
}