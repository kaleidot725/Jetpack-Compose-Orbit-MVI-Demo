package jp.kaleidot725.orbit.ui.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS
import jp.kaleidot725.orbit.ui.atoms.PokemonCard

@Composable
fun PokemonTwoCard(
    one: PokemonDetails? = null,
    onClickedOne: (() -> Unit)? = null,
    two: PokemonDetails? = null,
    onClickedTwo: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        if (one != null) {
            PokemonCard(
                pokemonDetails = one,
                onClick = { onClickedOne?.invoke() },
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction = 0.5f)
                    .padding(4.dp)
            )
        }

        if (two != null) {
            PokemonCard(
                pokemonDetails = two,
                onClick = { onClickedTwo?.invoke() },
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
fun PokemonTwoCard_Preview() {
    PokemonTwoCard(
        one = SAMPLE_POKEMON_DETAILS,
        two = SAMPLE_POKEMON_DETAILS,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun PokemonTwoCard_TwoNull_Preview() {
    PokemonTwoCard(
        one = SAMPLE_POKEMON_DETAILS,
        two = null,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
    )
}
