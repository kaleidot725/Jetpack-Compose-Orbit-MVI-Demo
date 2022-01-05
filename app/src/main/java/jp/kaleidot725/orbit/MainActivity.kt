package jp.kaleidot725.orbit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import jp.kaleidot725.orbit.ui.page.library.PokemonLibraryPage
import jp.kaleidot725.orbit.ui.theme.OrbitTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrbitTheme {
                PokemonLibraryPage(viewModel = getViewModel())
            }
        }
    }
}