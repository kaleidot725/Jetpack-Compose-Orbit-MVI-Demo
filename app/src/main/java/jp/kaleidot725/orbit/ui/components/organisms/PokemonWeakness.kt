package jp.kaleidot725.orbit.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import jp.kaleidot725.orbit.data.entity.WeaknessEntity
import jp.kaleidot725.orbit.data.entity.WeaknessEntity.Companion.toPokemonType
import jp.kaleidot725.orbit.data.enum.PokemonType
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS
import jp.kaleidot725.orbit.ui.theme.Colors

@OptIn(ExperimentalCoilApi::class)
@Composable
fun PokemonWeakness(weakness: WeaknessEntity, modifier: Modifier = Modifier) {
    SmallCard(
        text = weakness.value,
        backGroundColor = weakness.toPokemonType().toColor(),
        modifier = modifier
    )
}

private fun PokemonType.toColor(): androidx.compose.ui.graphics.Color {
    return when (this) {
        PokemonType.GRASS -> Colors.Grass
        PokemonType.POISON -> Colors.Poison
        PokemonType.FIRE -> Colors.Fire
        PokemonType.FLYING -> Colors.Flying
        PokemonType.WATER -> Colors.Water
        PokemonType.BUG -> Colors.Bug
        PokemonType.NORMAL -> Colors.Normal
        PokemonType.ELECTRIC -> Colors.Electric
        PokemonType.GROUND -> Colors.Ground
        PokemonType.FIGHTING -> Colors.Fighting
        PokemonType.PSYCHIC -> Colors.Psychic
        PokemonType.ROCK -> Colors.Rock
        PokemonType.ICE -> Colors.Ice
        PokemonType.GHOST -> Colors.Ghost
        PokemonType.DRAGON -> Colors.Dragon
        PokemonType.UNKNOWN -> Colors.Unknown
    }
}

@Preview
@Composable
private fun PokemonWeakness_Preview() {
    Column {
        SAMPLE_POKEMON_DETAILS.weaknesses.forEach { weaknesses ->
            PokemonWeakness(
                weakness = weaknesses,
                modifier = Modifier.wrapContentSize()
            )
        }
    }
}
