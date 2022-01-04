package jp.kaleidot725.data.dao

import androidx.room.*
import jp.kaleidot725.data.entity.PokemonEntity

@Dao
interface PokemonDao {
    @Insert
    suspend fun insert(pokemon: PokemonEntity)

    @Update
    suspend fun update(pokemon: PokemonEntity)

    @Delete
    suspend fun delete(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemons")
    suspend fun getAll(): List<PokemonEntity>
}