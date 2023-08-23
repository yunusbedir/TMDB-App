package ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.result.BaseMediaModel
import domain.model.result.MediaResult


@Composable
fun MediaList(
    trendsOfDay: List<BaseMediaModel>,
    popular: List<BaseMediaModel>,
    topRated: List<BaseMediaModel>,
    nowPlaying: List<BaseMediaModel>? = null,
    upComing: List<BaseMediaModel>? = null,
    onTheAir: List<BaseMediaModel>? = null,
    airingToday: List<BaseMediaModel>? = null,
    modifier: Modifier = Modifier,
    clickMedia: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        state = rememberLazyListState(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            AnimatedVisibility(visible = trendsOfDay.isNotEmpty()) {
                AutoScrollingHorizontalSlider(trendsOfDay.size) { page, modifier ->
                    val media = trendsOfDay[page]
                    TopMediaCard(
                        media = media,
                        onPlayClick = { },
                        onDetailsClick = { },
                        modifier = modifier
                    )
                }
            }
            AnimatedVisibility(visible = trendsOfDay.isEmpty()) {
                AutoScrollingHorizontalSlider(1) { page, modifier ->
                    Box(modifier = modifier)
                }
            }
        }
        item {
            TitleAndMediaLazyRow(
                title = "Popular",
                mediaList = popular,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        item {
            TitleAndMediaLazyRow(
                title = "Top Rated",
                mediaList = topRated,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        nowPlaying?.let {
            item {
                TitleAndMediaLazyRow(
                    title = "Now Playing",
                    mediaList = nowPlaying,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
        upComing?.let {
            item {
                TitleAndMediaLazyRow(
                    title = "Up Coming",
                    mediaList = upComing,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
        onTheAir?.let {
            item {
                TitleAndMediaLazyRow(
                    title = "On The Air",
                    mediaList = onTheAir,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
        airingToday?.let {
            item {
                TitleAndMediaLazyRow(
                    title = "Airing Today",
                    mediaList = airingToday,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

@Composable
fun TitleAndMediaLazyRow(
    title: String,
    mediaList: List<BaseMediaModel>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 8.dp, top = 4.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(
                    Alignment.CenterStart
                )

            )
            Text(
                modifier = Modifier.align(
                    Alignment.CenterEnd
                ).fillMaxHeight()
                    .width(48.dp)
                    .background(Color.White, MaterialTheme.shapes.small),
                text = "All",
                textAlign = TextAlign.Center,
                color = Color.DarkGray,
                fontSize = 12.sp,
            )
        }

        LazyRow {
            item {
                AnimatedVisibility(visible = mediaList.isEmpty()) {
                    Box(modifier = Modifier.padding(8.dp).height(250.dp).width(350.dp))
                }
            }
            itemsIndexed(mediaList) { index, item ->
                HorizontalMediaCard(
                    mediaModel = item,
                    modifier = Modifier.padding(8.dp).height(250.dp).width(350.dp)
                )
            }
        }
    }
}