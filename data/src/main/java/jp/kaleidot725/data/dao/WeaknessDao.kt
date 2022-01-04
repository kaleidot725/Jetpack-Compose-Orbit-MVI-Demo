package jp.kaleidot725.data.dao

import androidx.room.*
import jp.kaleidot725.data.entity.TypeEntity
import jp.kaleidot725.data.entity.WeaknessEntity

@Dao
interface WeaknessDao {
    @Insert
    suspend fun insert(weakness: WeaknessEntity)

    @Update
    suspend fun update(weakness: WeaknessEntity)

    @Delete
    suspend fun delete(weakness: WeaknessEntity)

    @Query("SELECT * FROM weaknesses where pokemonId = :pokemonId")
    suspend fun findTypes(pokemonId: Int): List<WeaknessEntity>
}