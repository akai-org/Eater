package pl.org.akai.eater.ui

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColors(
    primary = Primary002,
    primaryVariant = Primary001,
    onPrimary = White,
    background = White,
    surface = White,
    onBackground = Black,
    onSurface = Black,
    error = Danger002,
    onError = White,
)

@Composable
fun EaterTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColors,
        typography = EaterTypography,
        shapes = EaterShapes,
        content = content
    )
}