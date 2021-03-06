package jp.kaleidot725.orbit.ui.components.organisms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import jp.kaleidot725.orbit.R
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS
import jp.kaleidot725.orbit.ui.components.molecules.PokemonWeakness

@Composable
fun PokemonWeaknesses(details: PokemonDetails, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.weakness_title),
            style = MaterialTheme.typography.h5,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        FlowRow {
            details.weaknesses.forEach { weakness ->
                PokemonWeakness(weakness = weakness, modifier = Modifier.padding(end = 8.dp))
            }
        }
    }
}

@Preview
@Composable
private fun PokemonWeaknesses_Preview() {
    PokemonWeaknesses(
        details = SAMPLE_POKEMON_DETAILS,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}
