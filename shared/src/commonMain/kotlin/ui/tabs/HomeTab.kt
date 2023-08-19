package ui.tabs

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
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
import ui.screen.top.home.HomeScreen
import ui.screen.top.home.HomeScreenViewModel

internal object HomeTab : Tab {

    private val homeScreenViewModel: HomeScreenViewModel
        @Composable get() = rememberScreenModel { HomeScreenViewModel() }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 0u,
            title = "Home",
            icon = rememberVectorPainter(Icons.Rounded.Home)
        )

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    override fun Content() {
        BottomSheetNavigator(
            modifier = Modifier.animateContentSize(),
            sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            skipHalfExpanded = true
        ) {
            Navigator(HomeScreen(viewModel = homeScreenViewModel)) { _ ->
                CurrentScreen()
            }
        }
    }
}