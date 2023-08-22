package ui.presentation.movie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ui.components.MediaList
import ui.presentation.tab.home.HomeScreenViewModel

@Composable
fun MovieScreen(
    viewModel: HomeScreenViewModel,
    bottomSheetNavigator: BottomSheetNavigator = LocalBottomSheetNavigator.current,
    navigator: Navigator = LocalNavigator.currentOrThrow
) {
    LaunchedEffect("MovieScreen") {
        viewModel.getMovies()
    }

    val uiState = viewModel.uiStateMovie.collectAsState()
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
            MediaList(
                trendsOfDay = uiState.value.trendsOfDay,
                popular = uiState.value.popular,
                topRated = uiState.value.topRated,
                nowPlaying = uiState.value.nowPlaying,
                upComing = uiState.value.upComing,
                modifier = Modifier.fillMaxWidth(),
                clickMedia = { id ->

                }
            )
        }

    }
}