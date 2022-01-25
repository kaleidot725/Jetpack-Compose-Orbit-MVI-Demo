package jp.kaleidot725.orbit.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xff4c8c4a),
    primaryVariant = Color(0xff000000),
    secondary = Color(0xff212121),
    secondaryVariant = Color(0xff212121),
    onPrimary = Color(0xffffffff)
)

private val LightColorPalette = lightColors(
    primary = Color(0xff4c8c4a),
    primaryVariant = Color(0xff4c8c4a),
    secondary = Color(0xff212121),
    secondaryVariant = Color(0xff212121),
    onPrimary = Color(0xffffffff)
)

@Composable
fun OrbitTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}