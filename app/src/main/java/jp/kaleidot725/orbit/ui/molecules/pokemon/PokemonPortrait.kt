package jp.kaleidot725.orbit.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

    Column(modifier = modifier.background(MaterialTheme.colors.primary)) {
        Image(
            contentDescription = null,
            contentScale = ContentScale.Fit,
            painter = painter,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
        )

        Text(
            text = pokemonDetails.pokemon.name,
            style = MaterialTheme.typography.h4,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
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
            .wrapContentHeight()
            .width(200.dp)
    )
}