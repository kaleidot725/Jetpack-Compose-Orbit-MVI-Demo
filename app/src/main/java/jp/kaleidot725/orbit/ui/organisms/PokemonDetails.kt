package jp.kaleidot725.orbit.ui.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS
import jp.kaleidot725.orbit.ui.molecules.PokemonPortrait

@Composable
fun PokemonDetails(
    details: PokemonDetails,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        LazyColumn {
            item {
                PokemonPortrait(
                    pokemonDetails = details,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview_PokemonDetails() {
    PokemonDetails(details = SAMPLE_POKEMON_DETAILS)
}