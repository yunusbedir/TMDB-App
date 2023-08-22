package ui.presentation.tab.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import domain.model.result.BaseMediaModel
import ui.components.AutoScrollingHorizontalSlider
import ui.components.CapsuleButton
import ui.components.NumberMediaCard
import ui.components.TopMediaCard


internal class HomeScreen(
    private val viewModel: HomeScreenViewModel
) : Screen {

    @Composable
    override fun Content() {
        HomeScreenComponent(
            viewModel = viewModel
        )
    }
}

@Composable
fun HomeScreenComponent(
    viewModel: HomeScreenViewModel,
    bottomSheetNavigator: BottomSheetNavigator = LocalBottomSheetNavigator.current,
    navigator: Navigator = LocalNavigator.currentOrThrow
) {

    LaunchedEffect("homeScreenViewModel") {
        println("MY_LOG , homeScreenViewModel.getMovies()")
        viewModel.getTrending()
        viewModel.getMovies()
    }

    val uiState = viewModel.uiState.collectAsState()
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
            MediaList(
                trendsOfDay = uiState.value.trendsOfDay,
                popularMovies = uiState.value.popularMovies,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
fun MediaList(
    trendsOfDay: List<BaseMediaModel>,
    popularMovies: List<BaseMediaModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        state = rememberLazyListState(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            AnimatedVisibility(visible = trendsOfDay.isNotEmpty()) {
                AutoScrollingHorizontalSlider(trendsOfDay.size) { page ->
                    val media = trendsOfDay[page]
                    TopMediaCard(
                        media = media,
                        onPlayClick = { },
                        onDetailsClick = { }
                    )
                }
            }
        }
        item {
            TitleAndMediaLazyRow(
                title = "Popular Movie",
                mediaList = popularMovies,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        item {
            TitleAndMediaLazyRow(
                title = "Popular Tv",
                mediaList = popularMovies,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        item {
            TitleAndMediaLazyRow(
                title = "Discover Movie",
                mediaList = popularMovies,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        item {
            TitleAndMediaLazyRow(
                title = "Discover Tv",
                mediaList = popularMovies,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
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
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 8.dp, top = 4.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth().weight(1f)
                    .wrapContentSize(Alignment.Center)
            )
            Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
            Text(
                modifier = Modifier.fillMaxWidth().weight(1f),
                text = "Show More..",
                textAlign = TextAlign.Center,
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }

        LazyRow {
            itemsIndexed(mediaList) { index, item ->
                NumberMediaCard(
                    index = index,
                    media = item,
                    modifier = Modifier
                )
            }
        }
    }
}