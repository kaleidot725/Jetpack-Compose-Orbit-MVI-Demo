package jp.kaleidot725.orbit.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import jp.kaleidot725.orbit.R
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PokemonPortrait(pokemonDetails: PokemonDetails, modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(MaterialTheme.colors.primary)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pokemonDetails.image.localUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(
                if (isSystemInDarkTheme()) {
                    R.drawable.ic_question_white
                } else {
                    R.drawable.ic_question_black
                }
            ),
            error = painterResource(R.drawable.ic_error),
            contentDescription = null,
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
