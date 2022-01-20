package jp.kaleidot725.orbit.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
)