package jp.kaleidot725.orbit.ui.components.molecules

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PokemonWeight(weight: String, modifier: Modifier = Modifier) {
    SmallCard(text = "Weight : $weight", modifier = modifier)
}

@Preview
@Composable
private fun PokemonWeight_Preview() {
    PokemonWeight(
        weight = "19.65KG",
        modifier = Modifier.wrapContentSize()
    )
}
