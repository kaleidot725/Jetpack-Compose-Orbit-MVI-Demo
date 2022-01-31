package jp.kaleidot725.orbit.data.repository

import android.content.Context
import androidx.core.content.edit

class ConfigRepository(private val context: Context) {
    private val preferences get() = context.getSharedPreferences("PREFS", Context.MODE_PRIVATE)
    var createdDatabase: Boolean = false
        get() {
            return preferences.getBoolean("CREATED_DATABASE", false)
        }
        set(value) {
            preferences.edit {
                putBoolean("CREATED_DATABASE", value)
            }
            field = value
        }
}