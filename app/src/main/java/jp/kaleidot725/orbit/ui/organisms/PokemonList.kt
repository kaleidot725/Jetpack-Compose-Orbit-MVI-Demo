package jp.kaleidot725.orbit.ui.organisms

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS_LIST
import jp.kaleidot725.orbit.ui.atoms.PokemonCard

@Composable
fun PokemonList(details: List<PokemonDetails>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
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