package jp.kaleidot725.orbit.ui.components.pages.library

sealed class LibrarySideEffect {
    data class ShowDetails(val id: Int) : LibrarySideEffect()
}
