package jp.kaleidot725.orbit.ui.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
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
import jp.kaleidot725.orbit.R
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterialApi::class)
@Composable
fun PokemonCard(
    pokemonDetails: PokemonDetails,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
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

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(8.dp)
        ) {
            Image(
                contentDescription = null,
                contentScale = ContentScale.Fit,
                painter = painter,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = pokemonDetails.pokemon.name,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun Preview_PokemonCard() {
    PokemonCard(
        pokemonDetails = SAMPLE_POKEMON_DETAILS,
        onClick = {},
        modifier = Modifier
            .size(150.dp)
            .background(Color.Black)
    )
}
