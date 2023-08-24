package ui.presentation.moviedetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import domain.model.result.BaseMediaModel
import ui.components.DetailMediaTopBox


class MovieDetailScreen(
    private val navigator: Navigator,
    private val movieMedia: BaseMediaModel
) :
    Screen {

    @Composable
    override fun Content() {
        MovieDetailScreenComponent(navigator = navigator, movieMedia = movieMedia)
    }

}

@Composable
fun MovieDetailScreenComponent(navigator: Navigator, movieMedia: BaseMediaModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = movieMedia.title)
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable {
                            navigator.pop()
                        }
                    )
                }
            )
        }
    ) {
        DetailMediaTopBox(
            backdropPath = movieMedia.backdropPath,
            posterPath = movieMedia.posterPath,
            modifier = Modifier.padding(it),
            posterContent = {
                Text(
                    text = movieMedia.title,
                    style = MaterialTheme.typography.h2
                )
                Text(
                    text = movieMedia.id,
                    style = MaterialTheme.typography.h3
                )
            }
        ) {
            Text(
                text = movieMedia.id,
                style = MaterialTheme.typography.body2
            )
            Text(
                text = movieMedia.overview,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = movieMedia.id,
                style = MaterialTheme.typography.body2
            )
        }
    }
}