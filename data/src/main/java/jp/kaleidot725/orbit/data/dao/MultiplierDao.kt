package jp.kaleidot725.orbit.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import jp.kaleidot725.orbit.data.entity.MultiplierEntity

@Dao
interface MultiplierDao {
    @Insert
    suspend fun insert(multiplier: MultiplierEntity)

    @Insert
    suspend fun insertAll(multipliers: List<MultiplierEntity>)

    @Update
    suspend fun update(multiplier: MultiplierEntity)

    @Delete
    suspend fun delete(multiplier: MultiplierEntity)

    @Query("SELECT * FROM multipliers where pokemonId = :pokemonId")
    suspend fun findMultipliers(pokemonId: Int): List<MultiplierEntity>
}
