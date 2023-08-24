package ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun DetailMediaTopBox(
    backdropPath: String,
    posterPath: String,
    modifier: Modifier = Modifier,
    posterContent: (@Composable ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Box(modifier = modifier.fillMaxSize()) {
        AsyncImage(
            url = backdropPath,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
                .height(250.dp)
                .alpha(0.75f)
                .align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 100.dp, bottom = 8.dp)
                    .padding(horizontal = 16.dp)
                    .height(175.dp)
            ) {
                AsyncImage(
                    url = posterPath,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .width(125.dp)
                        .height(175.dp)
                        .shadow(
                            elevation = 4.dp,
                            shape = MaterialTheme.shapes.small,
                            spotColor = MaterialTheme.colors.onBackground,
                            ambientColor = MaterialTheme.colors.onBackground
                        )
                )
                Column(modifier = Modifier.fillMaxHeight()) {
                    posterContent?.let {
                        posterContent()
                    }
                }
            }
            content()
        }
    }
}