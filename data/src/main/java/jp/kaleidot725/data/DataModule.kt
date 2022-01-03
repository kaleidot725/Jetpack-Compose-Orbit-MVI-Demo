package jp.kaleidot725.data

import androidx.room.Room
import jp.kaleidot725.data.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    factory {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "pokemon-database").build()
    }

    factory {
        get<AppDatabase>().getMultiplierDao()
    }

    factory {
        get<AppDatabase>().getNextEvolutionDao()
    }

    factory {
        get<AppDatabase>().getPokemonDao()
    }

    factory {
        get<AppDatabase>().getTypeDao()
    }

    factory {
        get<AppDatabase>().getWeaknessDao()
    }
}