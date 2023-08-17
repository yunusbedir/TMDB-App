package ui.screen.other.tvdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import cafe.adriel.voyager.core.screen.Screen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


class TvDetailScreen(private val tvId: String) : Screen {

    @Composable
    override fun Content() {
        TvDetailScreenComponent(tvId = tvId)
    }

}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun TvDetailScreenComponent(tvId: String) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painterResource("compose-multiplatform.xml"),
            null
        )
        Text(
            text = "TvDetailScreen : $tvId",
            textAlign = TextAlign.Center,
        )
    }
}