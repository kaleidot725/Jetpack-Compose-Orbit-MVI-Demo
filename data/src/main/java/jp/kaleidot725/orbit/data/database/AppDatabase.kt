package jp.kaleidot725.orbit.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.kaleidot725.orbit.data.dao.ImageDao
import jp.kaleidot725.orbit.data.dao.MultiplierDao
import jp.kaleidot725.orbit.data.dao.NextEvolutionDao
import jp.kaleidot725.orbit.data.dao.PokemonDao
import jp.kaleidot725.orbit.data.dao.PrevEvolutionDao
import jp.kaleidot725.orbit.data.dao.TypeDao
import jp.kaleidot725.orbit.data.dao.WeaknessDao
import jp.kaleidot725.orbit.data.entity.ImageEntity
import jp.kaleidot725.orbit.data.entity.MultiplierEntity
import jp.kaleidot725.orbit.data.entity.NextEvolutionEntity
import jp.kaleidot725.orbit.data.entity.PokemonEntity
import jp.kaleidot725.orbit.data.entity.PrevEvolutionEntity
import jp.kaleidot725.orbit.data.entity.TypeEntity
import jp.kaleidot725.orbit.data.entity.WeaknessEntity

@Database(
    entities = [
        MultiplierEntity::class,
        NextEvolutionEntity::class,
        PrevEvolutionEntity::class,
        PokemonEntity::class,
        TypeEntity::class,
        WeaknessEntity::class,
        ImageEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMultiplierDao(): MultiplierDao
    abstract fun getNextEvolutionDao(): NextEvolutionDao
    abstract fun getPrevEvolutionDao(): PrevEvolutionDao
    abstract fun getPokemonDao(): PokemonDao
    abstract fun getTypeDao(): TypeDao
    abstract fun getWeaknessDao(): WeaknessDao
    abstract fun getImageDao(): ImageDao
}
