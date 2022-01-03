package jp.kaleidot725.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface MultiplierDao {
    @Insert
    suspend fun insert(memoEntity: MultiplierDao)

    @Update
    suspend fun update(memoEntity: MultiplierDao)

    @Delete
    suspend fun delete(memoEntity: MultiplierDao)
}