package jp.kaleidot725.orbit.ui.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PokemonCard(pokemonDetails: PokemonDetails, modifier: Modifier = Modifier) {
    Card(shape = RoundedCornerShape(8.dp), modifier = modifier) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(8.dp)
                    .align(Alignment.Center)
            ) {
                Image(
                    painter = rememberImagePainter(pokemonDetails.pokemon.img),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = pokemonDetails.pokemon.name,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview_PokemonCard() {
    PokemonCard(
        pokemonDetails = SAMPLE_POKEMON_DETAILS,
        modifier = Modifier
            .size(150.dp)
            .background(Color.Black)
    )
}