package ui.presentation.moviedetail

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen


class MovieDetailScreen(private val movieId: String) : Screen {

    @Composable
    override fun Content() {
        MovieDetailScreenComponent(movieId = movieId)
    }

}

@Composable
fun MovieDetailScreenComponent(movieId: String) {
}