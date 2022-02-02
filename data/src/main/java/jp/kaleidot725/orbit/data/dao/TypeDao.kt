package jp.kaleidot725.orbit.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import jp.kaleidot725.orbit.data.entity.TypeEntity

@Dao
interface TypeDao {
    @Insert
    suspend fun insert(type: TypeEntity)

    @Insert
    suspend fun insertAll(types: List<TypeEntity>)

    @Update
    suspend fun update(type: TypeEntity)

    @Delete
    suspend fun delete(type: TypeEntity)

    @Query("SELECT * FROM types where pokemonId = :pokemonId")
    suspend fun findTypes(pokemonId: Int): List<TypeEntity>
}
