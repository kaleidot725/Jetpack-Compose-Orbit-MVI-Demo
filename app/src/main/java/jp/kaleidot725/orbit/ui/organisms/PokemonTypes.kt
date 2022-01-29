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
import jp.kaleidot725.orbit.ui.molecules.PokemonType

@Composable
fun PokemonTypes(types: List<String>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.type_title),
            style = MaterialTheme.typography.h5,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

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