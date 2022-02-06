package jp.kaleidot725.orbit.domain

import jp.kaleidot725.orbit.domain.usecase.FetchAllPokemonUseCase
import jp.kaleidot725.orbit.domain.usecase.LoadPokemonDetailsUseCase
import jp.kaleidot725.orbit.domain.usecase.LoadPokemonEvolutionUseCase
import jp.kaleidot725.orbit.domain.usecase.SearchPokemonFromNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        FetchAllPokemonUseCase(pokemonRepository = get(), configRepository = get())
    }
    factory {
        LoadPokemonDetailsUseCase(pokemonRepository = get())
    }
    factory {
        LoadPokemonEvolutionUseCase(pokemonRepository = get())
    }
    factory {
        SearchPokemonFromNameUseCase(pokemonRepository = get())
    }
}
