package jp.kaleidot725.orbit.ui

import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.data.entity.PokemonEntity

val SAMPLE_POKEMON_DETAILS = PokemonDetails(
    pokemon = PokemonEntity(
        id = 0,
        avgSpawns = 0.0,
        candy = "candy",
        candyCount = 1,
        egg = "egg",
        height = "height",
        img = "img",
        name = "name",
        num = "num",
        spawnChance = 0.0,
        spawnTime = "spawntime",
        weight = "weight"
    ),
    multipliers = emptyList(),
    nextEvolutions = emptyList(),
    prevEvolutions = emptyList(),
    types = emptyList(),
    weaknesses = emptyList()
)

val SAMPLE_POKEMON_DETAILS_LIST = listOf(
    SAMPLE_POKEMON_DETAILS,
    SAMPLE_POKEMON_DETAILS,
    SAMPLE_POKEMON_DETAILS,
    SAMPLE_POKEMON_DETAILS
)
