package ui.presentation.tab.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import ui.presentation.movie.MovieScreen
import ui.presentation.tv.TvScreen


internal class HomeScreen(
    private val viewModel: HomeScreenViewModel
) : Screen {

    @Composable
    override fun Content() {
        var tabIndex by remember { mutableStateOf(0) }
        val tabs = listOf("Movie", "Tv")
        Column(modifier = Modifier.fillMaxWidth()) {
            TabRow(selectedTabIndex = tabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(text = { Text(title) },
                        selected = tabIndex == index,
                        onClick = { tabIndex = index }
                    )
                }
            }
            when (tabIndex) {
                0 -> MovieScreen(
                    viewModel = viewModel
                )

                1 -> TvScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}