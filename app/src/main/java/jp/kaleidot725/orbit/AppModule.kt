package jp.kaleidot725.orbit

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import jp.kaleidot725.orbit.ui.pages.details.DetailsViewModel
import jp.kaleidot725.orbit.ui.pages.library.LibraryViewModel
import org.koin.androidx.viewmodel.ViewModelOwner
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.koin.getViewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent

@Composable
fun getComposeViewModelOwner(): ViewModelOwner {
    return ViewModelOwner.from(
        LocalViewModelStoreOwner.current!!,
        LocalSavedStateRegistryOwner.current
    )
}

@Composable
inline fun <reified T : ViewModel> getComposeViewModel(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null,
): T {
    val viewModelOwner = getComposeViewModelOwner()
    return KoinJavaComponent.getKoin().getViewModel(qualifier, { viewModelOwner }, parameters)
}

val appModule = module {
    viewModel {
        LibraryViewModel(
            fetchAllPokemonUseCase = get(),
            searchPokemonUseCase = get()
        )
    }

    viewModel { (id: Int) ->
        DetailsViewModel(
            id = id,
            loadPokemonDetailsUseCase = get(),
            loadPokemonRevolutionUseCase = get()
        )
    }
}
