package jp.kaleidot725.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonDetails(
    @Embedded
    val pokemon: PokemonEntity,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = PokemonEntity::class)
    val multipliers: List<MultiplierEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = PokemonEntity::class)
    val nextEvolutions: List<NextEvolutionEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = PokemonEntity::class)
    val types: List<TypeEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = PokemonEntity::class)
    val weaknesses: List<WeaknessEntity>
)