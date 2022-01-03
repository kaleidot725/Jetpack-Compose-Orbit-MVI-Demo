package jp.kaleidot725.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import jp.kaleidot725.data.dto.NextEvolutionDto
import kotlinx.serialization.SerialName

@Entity(
    tableName = "pokemons"
)
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val avgSpawns: Int,
    val candy: String,
    val candyCount: Int,
    val egg: String,
    val height: String,
    val img: String,
    val name: String,
    val num: String,
    val spawnChance: Double,
    val spawnTime: String,
    val weaknesses: List<String>,
    val weight: String
)