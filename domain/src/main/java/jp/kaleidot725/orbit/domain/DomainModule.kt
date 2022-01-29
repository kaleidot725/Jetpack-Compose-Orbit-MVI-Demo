package jp.kaleidot725.orbit.domain

import jp.kaleidot725.orbit.domain.usecase.FetchAllPokemonUseCase
import jp.kaleidot725.orbit.domain.usecase.LoadPokemonDetailsUseCase
import jp.kaleidot725.orbit.domain.usecase.LoadPokemonRevolutionUseCase
import jp.kaleidot725.orbit.domain.usecase.SearchPokemonFromNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        FetchAllPokemonUseCase(pokemonRepository = get())
    }
    factory {
        LoadPokemonDetailsUseCase(pokemonRepository = get())
    }
    factory {
        LoadPokemonRevolutionUseCase(pokemonRepository = get())
    }
    factory {
        SearchPokemonFromNameUseCase(pokemonRepository = get())
    }
}