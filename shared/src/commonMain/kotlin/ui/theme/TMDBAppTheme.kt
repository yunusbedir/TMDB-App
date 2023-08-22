package ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green

val colorPallete =
    darkColors(
        primary = GreenSecondary,
        primaryVariant = YellowGreen,
        secondary = Green,
        secondaryVariant = YellowGreenSecondary,
        background = Background,
        surface = Background,
        onPrimary = Color.White,
        onSecondary = DarkGrey,
        onBackground = DarkGrey,
        onSurface = DarkGrey,
        error = Danger,
        onError = Color.Red
    )

@Composable
fun TMDBAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = colorPallete,
        typography = TMDBAppTypography,
        shapes = TMDBAppShape,
        content = {
            content()
        })
}
