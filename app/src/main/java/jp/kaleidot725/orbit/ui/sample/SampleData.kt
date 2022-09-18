package jp.kaleidot725.orbit.ui

import jp.kaleidot725.orbit.data.entity.ImageEntity
import jp.kaleidot725.orbit.data.entity.NextEvolutionEntity
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.data.entity.PokemonEntity
import jp.kaleidot725.orbit.data.entity.PrevEvolutionEntity
import jp.kaleidot725.orbit.data.entity.TypeEntity
import jp.kaleidot725.orbit.data.entity.WeaknessEntity

val SAMPLE_TYPES = listOf(
    TypeEntity(id = 0, pokemonId = 0, value = "Grass"),
    TypeEntity(id = 0, pokemonId = 0, value = "Poison"),
    TypeEntity(id = 0, pokemonId = 0, value = "Fire"),
    TypeEntity(id = 0, pokemonId = 0, value = "Flying"),
    TypeEntity(id = 0, pokemonId = 0, value = "Water"),
    TypeEntity(id = 0, pokemonId = 0, value = "Bug"),
    TypeEntity(id = 0, pokemonId = 0, value = "Normal"),
    TypeEntity(id = 0, pokemonId = 0, value = "Electric"),
    TypeEntity(id = 0, pokemonId = 0, value = "Ground"),
    TypeEntity(id = 0, pokemonId = 0, value = "Fighting"),
    TypeEntity(id = 0, pokemonId = 0, value = "Psychic"),
    TypeEntity(id = 0, pokemonId = 0, value = "Rock"),
    TypeEntity(id = 0, pokemonId = 0, value = "Ice"),
    TypeEntity(id = 0, pokemonId = 0, value = "Ghost"),
    TypeEntity(id = 0, pokemonId = 0, value = "Dragon")
)

val SAMPLE_WEAKNESSES = listOf(
    WeaknessEntity(id = 0, pokemonId = 0, value = "Grass"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Poison"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Fire"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Flying"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Water"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Bug"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Normal"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Electric"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Ground"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Fighting"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Psychic"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Rock"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Ice"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Ghost"),
    WeaknessEntity(id = 0, pokemonId = 0, value = "Dragon")
)

val SAMPLE_NEXT_EVOLUTIONS = listOf(
    NextEvolutionEntity(id = 0, pokemonId = 0, name = "NEXT_NAME", num = "NUMBER")
)

val SAMPLE_PREV_EVOLUTIONS = listOf(
    PrevEvolutionEntity(id = 0, pokemonId = 0, name = "PREV_NAME", num = "NUMBER")
)

val SAMPLE_POKEMON_DETAILS = PokemonDetails(
    pokemon = PokemonEntity(
        id = 0,
        avgSpawns = 0.0,
        candy = "candy",
        candyCount = 1,
        egg = "egg",
        height = "height",
        name = "name",
        num = "num",
        spawnChance = 0.0,
        spawnTime = "spawntime",
        weight = "weight"
    ),
    multipliers = emptyList(),
    nextEvolutions = SAMPLE_NEXT_EVOLUTIONS,
    prevEvolutions = SAMPLE_PREV_EVOLUTIONS,
    types = SAMPLE_TYPES,
    weaknesses = SAMPLE_WEAKNESSES,
    image = ImageEntity(0, 0, "")
)

val SAMPLE_POKEMON_DETAILS_LIST = listOf(
    SAMPLE_POKEMON_DETAILS,
    SAMPLE_POKEMON_DETAILS,
    SAMPLE_POKEMON_DETAILS,
    SAMPLE_POKEMON_DETAILS
)
