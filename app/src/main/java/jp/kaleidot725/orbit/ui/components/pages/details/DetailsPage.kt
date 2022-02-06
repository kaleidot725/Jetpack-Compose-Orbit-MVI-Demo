package jp.kaleidot725.orbit.ui.components.pages.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import jp.kaleidot725.orbit.ui.components.molecules.BackButton
import jp.kaleidot725.orbit.ui.components.molecules.ErrorMessage
import jp.kaleidot725.orbit.ui.components.molecules.LoadingIndicator
import jp.kaleidot725.orbit.ui.components.molecules.PokemonPortrait
import jp.kaleidot725.orbit.ui.components.organisms.PokemonBreeding
import jp.kaleidot725.orbit.ui.components.organisms.PokemonEvolutions
import jp.kaleidot725.orbit.ui.components.organisms.PokemonTypes
import jp.kaleidot725.orbit.ui.components.organisms.PokemonWeaknesses
import kotlinx.coroutines.flow.collect
import jp.kaleidot725.orbit.ui.components.pages.details.PokemonDataList as PokemonDataList1

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
                val evolutions = state.evolutions

                Box(modifier = Modifier.fillMaxSize()) {
                    PokemonDataList1(
                        details = details,
                        evolutions = evolutions,
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
    evolutions: List<PokemonDetails>,
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
            PokemonEvolutions(
                details = evolutions,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            )
        }
    }
}
