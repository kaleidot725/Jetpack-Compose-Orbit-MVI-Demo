package jp.kaleidot725.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import jp.kaleidot725.data.entity.TypeEntity

@Dao
interface WeaknessDao {
    @Insert
    suspend fun insert(memoEntity: TypeEntity)

    @Update
    suspend fun update(memoEntity: TypeEntity)

    @Delete
    suspend fun delete(memoEntity: TypeEntity)
}