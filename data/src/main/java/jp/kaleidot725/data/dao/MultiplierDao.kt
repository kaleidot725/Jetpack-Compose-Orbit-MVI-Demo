package jp.kaleidot725.data.dao

import androidx.room.*
import jp.kaleidot725.data.entity.MultiplierEntity

@Dao
interface MultiplierDao {
    @Insert
    suspend fun insert(multiplier: MultiplierEntity)

    @Update
    suspend fun update(multiplier: MultiplierEntity)

    @Delete
    suspend fun delete(multiplier: MultiplierEntity)

    @Query("SELECT * FROM multipliers where pokemonId = :pokemonId")
    suspend fun findMultipliers(pokemonId: Int): List<MultiplierEntity>
}