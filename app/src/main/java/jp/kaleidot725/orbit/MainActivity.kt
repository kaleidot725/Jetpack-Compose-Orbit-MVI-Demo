package jp.kaleidot725.orbit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.kaleidot725.orbit.ui.molecules.TopBar
import jp.kaleidot725.orbit.ui.pages.details.DetailsPage
import jp.kaleidot725.orbit.ui.pages.library.LibraryPage
import jp.kaleidot725.orbit.ui.theme.OrbitTheme
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ViewModelOwner
import org.koin.androidx.viewmodel.koin.getViewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            OrbitTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar() },
                    content = {
                        @Composable
                        fun getComposeViewModelOwner(): ViewModelOwner {
                            return ViewModelOwner.from(
                                LocalViewModelStoreOwner.current!!,
                                LocalSavedStateRegistryOwner.current
                            )
                        }

                        NavHost(navController, startDestination = "library") {
                            composable("library") {
                                val viewModelOwner = getComposeViewModelOwner()
                                LibraryPage(
                                    viewModel = getKoin().getViewModel(owner = { viewModelOwner }),
                                    onShowDetail = { id ->
                                        navController.navigate("details/${id}") // FIXME
                                    }
                                )
                            }
                            composable("details/{id}") {
                                val viewModelOwner = getComposeViewModelOwner()
                                val id = parametersOf(it.arguments?.getString("id")?.toInt() ?: 0)
                                DetailsPage(
                                    viewModel = getKoin().getViewModel(
                                        owner = { viewModelOwner },
                                        parameters = { id }
                                    ),
                                    onBack = { navController.popBackStack() }
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}