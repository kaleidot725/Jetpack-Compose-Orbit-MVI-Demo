package jp.kaleidot725.orbit.data.dao

import androidx.room.*
import jp.kaleidot725.orbit.data.entity.PrevEvolutionEntity

@Dao
interface PrevEvolutionDao {
    @Insert
    suspend fun insert(prevEvolution: PrevEvolutionEntity)

    @Insert
    suspend fun insertAll(prevEvolutions: List<PrevEvolutionEntity>)

    @Update
    suspend fun update(prevEvolution: PrevEvolutionEntity)

    @Delete
    suspend fun delete(prevEvolution: PrevEvolutionEntity)

    @Query("SELECT * FROM next_evolutions where pokemonId = :pokemonId")
    suspend fun findNextEvolutions(pokemonId: Int): List<PrevEvolutionEntity>
}