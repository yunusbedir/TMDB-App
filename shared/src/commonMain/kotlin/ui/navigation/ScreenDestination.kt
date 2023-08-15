package ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import ui.screen.other.moviedetail.MovieDetailScreen
import ui.screen.other.tvdetail.TvDetailScreen
import ui.screen.top.favorite.FavoriteScreen
import ui.screen.top.home.HomeScreen
import ui.screen.top.search.SearchScreen

sealed class ScreenDestination(
    val label: String,
    val icon: ImageVector? = null,
    val isTopScreen: Boolean = false
) {

    @Composable
    open fun content(
        navigateTo: (ScreenDestination) -> Unit
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Can not found Screen")
        }
    }

    class Home : ScreenDestination(
        label = "Home",
        icon = Icons.Outlined.Home,
        isTopScreen = true
    ) {
        @Composable
        override fun content(navigateTo: (ScreenDestination) -> Unit) {
            HomeScreen()
        }
    }

    class Search : ScreenDestination(
        label = "Search",
        icon = Icons.Outlined.Search,
        isTopScreen = true
    ) {
        @Composable
        override fun content(navigateTo: (ScreenDestination) -> Unit) {
            SearchScreen()
        }
    }

    class Favorite : ScreenDestination(
        label = "Favorite",
        icon = Icons.Outlined.Favorite,
        isTopScreen = true
    ) {
        @Composable
        override fun content(navigateTo: (ScreenDestination) -> Unit) {
            FavoriteScreen()
        }
    }

    data class TvDetailScreenDestination(val tvId: String) : ScreenDestination(
        label = "Tv Detail"
    ) {
        @Composable
        override fun content(navigateTo: (ScreenDestination) -> Unit) {
            TvDetailScreen(tvId = tvId)
        }
    }

    data class MovieDetailScreenDestination(val movieId: String) :
        ScreenDestination(label = "Tv Detail") {

        @Composable
        override fun content(navigateTo: (ScreenDestination) -> Unit) {
            MovieDetailScreen(movieId = movieId)
        }
    }

    companion object {
        val topScreenDestinations = arrayListOf(
            Home(),
            Search(),
            Favorite()
        )
    }
}
