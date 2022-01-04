package jp.kaleidot725.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.kaleidot725.data.dao.*
import jp.kaleidot725.data.entity.*

@Database(
    entities = [MultiplierEntity::class, NextEvolutionEntity::class, PrevEvolutionEntity::class, PokemonEntity::class, TypeEntity::class, WeaknessEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMultiplierDao(): MultiplierDao
    abstract fun getNextEvolutionDao(): NextEvolutionDao
    abstract fun getPrevEvolutionDao(): PrevEvolutionDao
    abstract fun getPokemonDao(): PokemonDao
    abstract fun getTypeDao(): TypeDao
    abstract fun getWeaknessDao(): WeaknessDao
}