package jp.kaleidot725.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "prev_evolutions",
    foreignKeys = [
        ForeignKey(
            entity = PokemonEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("pokemonId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class PrevEvolutionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val pokemonId: Int,
    val name: String,
    val num: String
)