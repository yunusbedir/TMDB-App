package ui.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.TabOptions
import ui.screen.top.favorite.FavoriteScreen

internal object FavoriteTab : BaseTab(FavoriteScreen()) {

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 2u,
            title = "Favorite",
            icon = rememberVectorPainter(Icons.Rounded.Favorite)
        )
}