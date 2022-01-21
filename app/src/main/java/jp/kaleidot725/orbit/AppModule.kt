package jp.kaleidot725.orbit

import jp.kaleidot725.orbit.ui.pages.details.DetailsViewModel
import jp.kaleidot725.orbit.ui.pages.library.LibraryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        LibraryViewModel(
            fetchAllPokemonUseCase = get(),
            searchPokemonUseCase = get()
        )
    }

    viewModel {
        DetailsViewModel()
    }
}