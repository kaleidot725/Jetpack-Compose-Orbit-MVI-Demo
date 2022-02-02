package jp.kaleidot725.orbit.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PokemonDetails(
    @Embedded
    val pokemon: PokemonEntity,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = MultiplierEntity::class)
    val multipliers: List<MultiplierEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = NextEvolutionEntity::class)
    val nextEvolutions: List<NextEvolutionEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = PrevEvolutionEntity::class)
    val prevEvolutions: List<PrevEvolutionEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = TypeEntity::class)
    val types: List<TypeEntity>,

    @Relation(parentColumn = "id", entityColumn = "pokemonId", entity = WeaknessEntity::class)
    val weaknesses: List<WeaknessEntity>
)
