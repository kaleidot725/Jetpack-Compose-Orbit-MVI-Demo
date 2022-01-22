package jp.kaleidot725.orbit.ui.organisms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
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
fun PokemonList(
    detailsList: List<PokemonDetails>,
    onClickedItem: ((id: Int) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(count = 2),
        modifier = modifier
    ) {
        detailsList.forEach { details ->
            item {
                PokemonCard(
                    pokemonDetails = details,
                    modifier = Modifier
                        .size(150.dp)
                        .padding(4.dp)
                        .clickable {
                            onClickedItem?.invoke(details.pokemon.id)
                        }
                )
            }
        }
    }
}

@Preview
@Composable
fun PokemonList_Preview() {
    PokemonList(detailsList = SAMPLE_POKEMON_DETAILS_LIST)
}