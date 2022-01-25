package jp.kaleidot725.orbit.ui.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PokemonTypes(pokemonDetails: PokemonDetails, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
    
    }
}

@Preview
@Composable
private fun PokemonTypes() {
    PokemonPortrait(
        pokemonDetails = SAMPLE_POKEMON_DETAILS,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}