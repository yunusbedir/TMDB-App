package ui.tabs

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import ui.screen.top.favorite.FavoriteScreen
import ui.screen.top.favorite.FavoriteScreenViewModel

internal object FavoriteTab : Tab {

    private val favoriteScreenViewModel: FavoriteScreenViewModel
        @Composable get() = rememberScreenModel { FavoriteScreenViewModel() }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 2u,
            title = "Favorite",
            icon = rememberVectorPainter(Icons.Rounded.Favorite)
        )

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    override fun Content() {
        BottomSheetNavigator(
            modifier = Modifier.animateContentSize(),
            sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            skipHalfExpanded = true
        ) {
            Navigator(FavoriteScreen(viewModel = favoriteScreenViewModel)) { _ ->
                CurrentScreen()
            }
        }
    }
}