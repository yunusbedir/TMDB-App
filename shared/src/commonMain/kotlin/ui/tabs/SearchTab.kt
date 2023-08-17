package ui.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.TabOptions
import ui.screen.top.search.SearchScreen

internal object SearchTab : BaseTab(SearchScreen()) {

    override val options: TabOptions
        @Composable get() = TabOptions(
            index = 1u,
            title = "Search",
            icon = rememberVectorPainter(Icons.Rounded.Search)
        )
}