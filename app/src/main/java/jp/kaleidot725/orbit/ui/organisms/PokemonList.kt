package jp.kaleidot725.orbit.ui.organisms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS_LIST
import jp.kaleidot725.orbit.ui.atoms.PokemonCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonList(details: List<PokemonDetails>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 128.dp),
        modifier = modifier
    ) {
        details.forEach { details ->
            item {
                PokemonCard(
                    pokemonDetails = details,
                    modifier = Modifier
                        .size(150.dp)
                        .padding(4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PokemonList_Preview() {
    PokemonList(details = SAMPLE_POKEMON_DETAILS_LIST)
}