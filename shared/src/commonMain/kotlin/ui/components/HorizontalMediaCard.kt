package ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import domain.model.result.BaseMediaModel

@Composable
fun HorizontalMediaCard(
    mediaModel: BaseMediaModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        elevation = 4.dp
    ) {
        Box(modifier = Modifier.height(250.dp).width(350.dp)) {
            AsyncImage(
                url = mediaModel.backdropPath,
                modifier = Modifier.height(250.dp).width(350.dp),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier.align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Card(
                    modifier = Modifier.width(85.dp).height(125.dp),
                    shape = MaterialTheme.shapes.medium,
                    elevation = 16.dp
                ) {
                    AsyncImage(
                        url = mediaModel.posterPath,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(
                    text = mediaModel.title,
                    textAlign = TextAlign.Start,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Bottom)
                )
            }
        }
    }
}