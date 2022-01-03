package jp.kaleidot725.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "mulltipliers",
    foreignKeys = [
        ForeignKey(
            entity = PokemonEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("pokemonId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class MultiplierEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val pokemonId: Int,
    val value: Double
)