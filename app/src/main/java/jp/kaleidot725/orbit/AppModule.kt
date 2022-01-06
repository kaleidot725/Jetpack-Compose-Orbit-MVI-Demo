package jp.kaleidot725.orbit.di

import jp.kaleidot725.orbit.ui.pages.library.PokemonLibraryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        PokemonLibraryViewModel(
            fetchAllPokemonUseCase = get(),
            loadAllPokemonUseCase = get()
        )
    }
}