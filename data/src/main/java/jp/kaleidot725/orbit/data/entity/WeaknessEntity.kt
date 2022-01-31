package jp.kaleidot725.orbit.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import jp.kaleidot725.orbit.data.enum.PokemonType

@Entity(
    tableName = "weaknesses",
    foreignKeys = [
        ForeignKey(
            entity = PokemonEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("pokemonId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class WeaknessEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val pokemonId: Int,
    val value: String
) {
    companion object {
        fun WeaknessEntity.toPokemonType(): PokemonType {
            return when (value) {
                "Grass" -> PokemonType.GRASS
                "Poison" -> PokemonType.POISON
                "Fire" -> PokemonType.FIRE
                "Flying" -> PokemonType.FLYING
                "Water" -> PokemonType.WATER
                "Bug" -> PokemonType.BUG
                "Normal" -> PokemonType.NORMAL
                "Electric" -> PokemonType.ELECTRIC
                "Ground" -> PokemonType.GROUND
                "Fighting" -> PokemonType.FIGHTING
                "Psychic" -> PokemonType.PSYCHIC
                "Rock" -> PokemonType.ROCK
                "Ice" -> PokemonType.ICE
                "Ghost" -> PokemonType.GHOST
                "Dragon" -> PokemonType.DRAGON
                else -> PokemonType.UNKNOWN
            }
        }
    }
}