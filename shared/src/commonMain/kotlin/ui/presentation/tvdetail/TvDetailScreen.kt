package ui.presentation.tvdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextAlign
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import domain.model.result.BaseMediaModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.components.DetailMediaTopBox


class TvDetailScreen(
    private val navigator: Navigator,
    private val tvMedia: BaseMediaModel
) : Screen {

    @Composable
    override fun Content() {
        TvDetailScreenComponent(navigator = navigator, tvMedia = tvMedia)
    }

}

@Composable
private fun TvDetailScreenComponent(navigator: Navigator, tvMedia: BaseMediaModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = tvMedia.title)
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
            backdropPath = tvMedia.backdropPath,
            posterPath = tvMedia.posterPath,
            modifier = Modifier.padding(it),
            posterContent = {
                Text(
                    text = tvMedia.title,
                    style = MaterialTheme.typography.h2
                )
                Text(
                    text = tvMedia.id,
                    style = MaterialTheme.typography.h3
                )
            }
        ) {
            Text(
                text = tvMedia.id,
                style = MaterialTheme.typography.body2
            )
            Text(
                text = tvMedia.overview,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = tvMedia.id,
                style = MaterialTheme.typography.body2
            )
        }
    }
}