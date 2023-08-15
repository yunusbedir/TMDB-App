import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ui.navigation.ScreenDestination
import ui.navigation.ScreenDestination.Companion.topScreenDestinations
import ui.navigation.TMDBBottomNavBar

@Composable
fun App() {
    var currentScreen: ScreenDestination by remember { mutableStateOf(ScreenDestination.Home()) }

    MaterialTheme {
        Scaffold(
            bottomBar = {
                TMDBBottomNavBar(
                    currentScreen = currentScreen,
                    topScreenDestinations = topScreenDestinations
                ) {
                    currentScreen = it
                }
            }
        ) {
            currentScreen.content { screenDestination ->
                currentScreen = screenDestination
            }
        }
    }
}

expect fun getPlatformName(): String