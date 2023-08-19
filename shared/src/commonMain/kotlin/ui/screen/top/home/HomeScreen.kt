package ui.screen.top.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
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
import ui.screen.other.tvdetail.TvDetailScreen


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
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(uiState.value.popularMovies) { index, item ->
                Button(onClick = {
                    navigator.push(TvDetailScreen(tvId = item))
                }) {
                    Text(item)
                }
            }
        }
    }
}