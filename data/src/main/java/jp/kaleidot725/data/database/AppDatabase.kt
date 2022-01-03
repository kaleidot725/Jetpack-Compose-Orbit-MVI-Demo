package jp.kaleidot725.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.kaleidot725.data.dao.*
import jp.kaleidot725.data.entity.*

@Database(
    entities = [MultiplierEntity::class, NextEvolutionEntity::class, PokemonEntity::class, TypeEntity::class, WeaknessEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getMultiplierDao() : MultiplierDao
    abstract fun getNextEvolutionDao(): NextEvolutionDao
    abstract fun getPokemonDao(): PokemonDao
    abstract fun getTypeDao(): TypeDao
    abstract fun getWeaknessDao(): WeaknessDao
}