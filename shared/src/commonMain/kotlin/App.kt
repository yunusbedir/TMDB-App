import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ui.components.TMDBBottomNavBar
import ui.tabs.FavoriteTab
import ui.tabs.HomeTab
import ui.tabs.SearchTab

@Composable
fun App() {
    MaterialTheme {
        TabNavigator(HomeTab) {
            Scaffold(
                scaffoldState = rememberScaffoldState(),
                bottomBar = {
                    TMDBBottomNavBar(
                        tabList = listOf(
                            HomeTab,
                            SearchTab,
                            FavoriteTab
                        )
                    )
                }
            ) {
                CurrentTab()
            }
        }
    }
}

expect fun getPlatformName(): String