package jp.kaleidot725.orbit.data

import androidx.room.Room
import jp.kaleidot725.orbit.data.database.AppDatabase
import jp.kaleidot725.orbit.data.datasource.PokemonDataSource
import jp.kaleidot725.orbit.data.repository.ConfigRepository
import jp.kaleidot725.orbit.data.repository.PokemonRepository
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    factory {
        OkHttpClient()
    }

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
        val db: AppDatabase = get()
        db.getImageDao()
    }

    factory {
        PokemonRepository(
            pokemonDataSource = get(),
            pokemonDao = get(),
            multiplierDao = get(),
            nextEvolutionDao = get(),
            prevEvolutionDao = get(),
            typeDao = get(),
            weaknessDao = get(),
            imageDao = get(),
            imageClient = get(),
            imageDirectory = androidApplication().filesDir.toString(),
            appDatabase = get()
        )
    }

    factory {
        ConfigRepository(
            context = androidContext()
        )
    }
}
