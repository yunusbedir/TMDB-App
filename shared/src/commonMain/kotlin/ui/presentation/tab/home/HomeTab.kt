package ui.presentation.tab.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.koin.compose.koinInject

internal object HomeTab : Tab {

    private val homeScreenViewModel: HomeScreenViewModel
        @Composable get() = koinInject()

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
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(bottom = 56.dp)
        ) {
            BottomSheetNavigator(
                modifier = Modifier.animateContentSize(),
                sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                skipHalfExpanded = true
            ) {
                Navigator(HomeScreen(viewModel = homeScreenViewModel)) { _ ->
                    CurrentScreen()
                }
            }
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colors.background.copy(
                                    alpha = 0.5f
                                )
                            ),
                            startX = 0.4f * 200.dp.value,
                            endX = 0.4f * 200.dp.value,
                            tileMode = TileMode.Mirror
                        ),
                    )
            )
        }
    }
}