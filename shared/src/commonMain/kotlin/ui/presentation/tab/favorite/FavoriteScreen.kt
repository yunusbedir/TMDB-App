package ui.presentation.tab.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ui.presentation.tvdetail.TvDetailScreen


internal class FavoriteScreen(
    private val viewModel: FavoriteScreenViewModel
) : Screen {

    @Composable
    override fun Content() {
        FavoriteScreenComponent(viewModel = viewModel)
    }

}

@Composable
fun FavoriteScreenComponent(
    viewModel: FavoriteScreenViewModel,
    bottomSheetNavigator: BottomSheetNavigator = LocalBottomSheetNavigator.current,
    navigator: Navigator = LocalNavigator.currentOrThrow
) {
    Column(modifier = Modifier.fillMaxSize()) {

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(listOf(1, 2, 3, 4, 5)) {
                    Button(onClick = {
                       // navigator.push(TvDetailScreen(tvId = "FavoriteScreen, $it"))
                    }) {
                        Text("FavoriteScreen, $it")
                    }
                }
            }
        }
    }
}