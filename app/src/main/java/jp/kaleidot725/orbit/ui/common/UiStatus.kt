package jp.kaleidot725.orbit.ui.common

sealed class UiStatus {
    object Loading : UiStatus()
    object Success : UiStatus()
    data class Failed(val message: String) : UiStatus()
}
