package jp.kaleidot725.orbit.ui.organisms

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.ui.molecules.PokemonType

@Composable
fun PokemonTypes(types: List<String>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Type", style = MaterialTheme.typography.h6)

        Spacer(modifier = Modifier.height(8.dp))
        
        Row {
            types.forEach { type ->
                PokemonType(type = type, modifier = Modifier.padding(end = 8.dp))
            }
        }
    }
}

@Preview
@Composable
private fun PokemonTypes_Preview() {
    PokemonTypes(
        types = listOf("ABCD", "BCDE", "CDEF"),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}