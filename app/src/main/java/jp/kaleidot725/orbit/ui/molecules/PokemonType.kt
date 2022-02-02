package jp.kaleidot725.orbit.ui.molecules

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import jp.kaleidot725.orbit.data.entity.TypeEntity
import jp.kaleidot725.orbit.data.entity.TypeEntity.Companion.toPokemonType
import jp.kaleidot725.orbit.data.enum.PokemonType
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PokemonType(typeEntity: TypeEntity, modifier: Modifier = Modifier) {
    Card(
        elevation = 2.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = typeEntity.toPokemonType().toColor(),
        modifier = modifier
    ) {
        Text(
            text = typeEntity.value,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(vertical = 2.dp)
                .padding(horizontal = 8.dp)
        )
    }
}

private fun PokemonType.toColor(): androidx.compose.ui.graphics.Color {
    return when (this) {
        PokemonType.GRASS -> Color.Grass
        PokemonType.POISON -> Color.Poison
        PokemonType.FIRE -> Color.Fire
        PokemonType.FLYING -> Color.Flying
        PokemonType.WATER -> Color.Water
        PokemonType.BUG -> Color.Bug
        PokemonType.NORMAL -> Color.Normal
        PokemonType.ELECTRIC -> Color.Electric
        PokemonType.GROUND -> Color.Ground
        PokemonType.FIGHTING -> Color.Fighting
        PokemonType.PSYCHIC -> Color.Psychic
        PokemonType.ROCK -> Color.Rock
        PokemonType.ICE -> Color.Ice
        PokemonType.GHOST -> Color.Ghost
        PokemonType.DRAGON -> Color.Dragon
        PokemonType.UNKNOWN -> Color.Unknown
    }
}

@Preview
@Composable
private fun PokemonType_Preview() {
    PokemonType(
        typeEntity = SAMPLE_POKEMON_DETAILS.types.first(),
        modifier = Modifier.wrapContentSize()
    )
}
