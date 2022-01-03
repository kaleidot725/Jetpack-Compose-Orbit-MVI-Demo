package jp.kaleidot725.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import jp.kaleidot725.data.entity.NextEvolutionEntity

@Dao
interface NextEvolutionDao {
    @Insert
    suspend fun insert(memoEntity: NextEvolutionEntity)

    @Update
    suspend fun update(memoEntity: NextEvolutionEntity)

    @Delete
    suspend fun delete(memoEntity: NextEvolutionEntity)
}