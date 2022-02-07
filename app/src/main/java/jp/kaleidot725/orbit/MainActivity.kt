package jp.kaleidot725.orbit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.kaleidot725.orbit.ui.components.pages.details.DetailsPage
import jp.kaleidot725.orbit.ui.components.pages.init.InitPage
import jp.kaleidot725.orbit.ui.components.pages.library.LibraryPage
import jp.kaleidot725.orbit.ui.screen.Screen
import jp.kaleidot725.orbit.ui.theme.OrbitTheme
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrbitTheme {
                window.statusBarColor = MaterialTheme.colors.primarySurface.toArgb()
                Box(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = Screen.Init.route) {
                        composable(route = Screen.Init.route) {
                            InitPage(
                                viewModel = getComposeViewModel(),
                                onCompleted = { navController.navigate(route = Screen.Library.route) }
                            )
                        }
                        composable(route = Screen.Library.route) {
                            LibraryPage(
                                viewModel = getComposeViewModel(),
                                onShowDetail = { id ->
                                    navController.navigate(route = Screen.Details.createRoute(id))
                                }
                            )
                        }
                        composable(route = Screen.Details.route) {
                            DetailsPage(
                                viewModel = getComposeViewModel(
                                    parameters = { parametersOf(Screen.Details.getArgumentId(it)) }
                                ),
                                onBack = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
