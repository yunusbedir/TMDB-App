import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import ui.components.TMDBBottomNavBar
import ui.presentation.tab.favorite.FavoriteTab
import ui.presentation.tab.home.HomeTab
import ui.presentation.tab.search.SearchTab
import ui.theme.TMDBAppTheme

@Composable
fun App() {
    TMDBAppTheme {
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