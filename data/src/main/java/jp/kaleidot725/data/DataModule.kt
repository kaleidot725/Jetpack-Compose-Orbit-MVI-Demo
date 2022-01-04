package jp.kaleidot725.data

import androidx.room.Room
import jp.kaleidot725.data.database.AppDatabase
import jp.kaleidot725.data.datasource.PokemonDataSource
import jp.kaleidot725.data.repository.PokemonRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    factory {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "pokemon-database").build()
    }

    factory {
        PokemonDataSource(androidContext())
    }

    factory {
        val db: AppDatabase = get()
        db.getMultiplierDao()
    }

    factory {
        val db: AppDatabase = get()
        db.getNextEvolutionDao()
    }

    factory {
        val db: AppDatabase = get()
        db.getPrevEvolutionDao()
    }

    factory {
        val db: AppDatabase = get()
        db.getPokemonDao()
    }

    factory {
        val db: AppDatabase = get()
        db.getTypeDao()
    }

    factory {
        val db: AppDatabase = get()
        db.getWeaknessDao()
    }

    factory {
        PokemonRepository(
            pokemonDataSource = get(),
            pokemonDao = get(),
            multiplierDao = get(),
            nextEvolutionDao = get(),
            prevEvolutionDao = get(),
            typeDao = get(),
            weaknessDao = get()
        )
    }
}