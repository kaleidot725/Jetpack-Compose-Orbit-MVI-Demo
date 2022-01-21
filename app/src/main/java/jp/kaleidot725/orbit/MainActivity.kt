package jp.kaleidot725.orbit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.kaleidot725.orbit.ui.molecules.TopBar
import jp.kaleidot725.orbit.ui.pages.details.DetailsPage
import jp.kaleidot725.orbit.ui.pages.library.LibraryPage
import jp.kaleidot725.orbit.ui.theme.OrbitTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

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
                        NavHost(navController, startDestination = "library") {
                            composable("library") {
                                LibraryPage(
                                    viewModel = getViewModel(),
                                    onShowDetail = { navController.navigate("details") }
                                )
                            }
                            composable("details") {
                                DetailsPage(
                                    viewModel = getViewModel(),
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