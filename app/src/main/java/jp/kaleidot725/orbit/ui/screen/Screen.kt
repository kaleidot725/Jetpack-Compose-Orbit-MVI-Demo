package jp.kaleidot725.orbit.ui.screen

import androidx.navigation.NavBackStackEntry

sealed class Screen(val route: String) {
    object Library : Screen(route = "library")
    object Details : Screen(route = "details/{id}") {
        fun createRoute(id: Int) = "details/$id"
        fun getArgumentId(entry: NavBackStackEntry): Int {
            return entry.arguments?.getString("id")?.toInt() ?: 0
        }
    }
}