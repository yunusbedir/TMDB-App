package ui.presentation.tab.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import domain.model.result.BaseMediaModel
import ui.components.AutoScrollingHorizontalSlider
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
                popularMovies = uiState.value.trendsOfDay,
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
            LazyRow {
                itemsIndexed(trendsOfDay) { index, item ->
                    NumberMediaCard(
                        index = index,
                        media = item,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}