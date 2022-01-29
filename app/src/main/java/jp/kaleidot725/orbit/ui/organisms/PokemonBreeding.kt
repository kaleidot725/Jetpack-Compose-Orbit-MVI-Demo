package jp.kaleidot725.orbit.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.R
import jp.kaleidot725.orbit.data.entity.PokemonEntity
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS
import jp.kaleidot725.orbit.ui.molecules.PokemonHeight
import jp.kaleidot725.orbit.ui.molecules.PokemonWeight

@Composable
fun PokemonBreeding(pokemonEntity: PokemonEntity, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.breeding_title),
            style = MaterialTheme.typography.h5,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            PokemonWeight(weight = pokemonEntity.weight, modifier = Modifier.padding(end = 8.dp))
            PokemonHeight(height = pokemonEntity.height, modifier = Modifier.padding(end = 8.dp))
        }
    }
}

@Preview
@Composable
private fun PokemonBreeding_Preview() {
    PokemonBreeding(SAMPLE_POKEMON_DETAILS.pokemon)
}