package jp.kaleidot725.orbit.ui.molecules

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PokemonHeight(height: String, modifier: Modifier = Modifier) {
    SmallCard(text = "Height : $height", modifier = modifier)
}

@Preview
@Composable
private fun PokemonHeight_Preview() {
    PokemonHeight(
        height = "1.00 m",
        modifier = Modifier.wrapContentSize()
    )
}
