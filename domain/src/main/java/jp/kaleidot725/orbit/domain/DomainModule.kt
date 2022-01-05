package jp.kaleidot725.orbit.domain

import jp.kaleidot725.orbit.domain.usecase.FetchAllPokemonUseCase
import jp.kaleidot725.orbit.domain.usecase.LoadAllPokemonUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        FetchAllPokemonUseCase(pokemonRepository = get())
    }
    factory {
        LoadAllPokemonUseCase(pokemonRepository = get())
    }
}