package jp.kaleidot725.orbit.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import jp.kaleidot725.orbit.R
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PokemonPortrait(pokemonDetails: PokemonDetails, modifier: Modifier = Modifier) {
    val painter = rememberImagePainter(pokemonDetails.pokemon.img) {
        crossfade(200)
        error(R.drawable.ic_error)
        placeholder(
            if (isSystemInDarkTheme()) {
                R.drawable.ic_question_white
            } else {
                R.drawable.ic_question_black
            }
        )
    }

    Box(modifier = modifier) {
        Image(
            contentDescription = null,
            contentScale = ContentScale.Fit,
            painter = painter,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primary)
                .padding(32.dp)
        )

        val number = String.format("%03d", pokemonDetails.pokemon.num.toInt())
        val name = pokemonDetails.pokemon.name
        Text(
            text = "No.$number $name",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .align(
                    Alignment.BottomCenter
                )
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun Preview_PokemonPortrait() {
    PokemonPortrait(
        pokemonDetails = SAMPLE_POKEMON_DETAILS,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .width(200.dp)
    )
}