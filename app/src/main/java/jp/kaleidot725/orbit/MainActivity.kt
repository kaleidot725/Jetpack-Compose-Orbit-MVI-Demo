package jp.kaleidot725.orbit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.kaleidot725.orbit.ui.pages.library.PokemonLibraryPage
import jp.kaleidot725.orbit.ui.theme.OrbitTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrbitTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "library") {
                    composable("library") {
                        PokemonLibraryPage(viewModel = getViewModel())
                    }
                }
            }
        }
    }
}