package ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AutoScrollingHorizontalSlider(
    size: Int,
    delay: Long = 2000,
    animationDuration: Int = 2000,
    content: @Composable (page: Int) -> Unit
) {
    val pagerState = rememberPagerState(1)

    LaunchedEffect(key1 = pagerState) {
        while (true) {
            val nextPage = (pagerState.currentPage + 1) % size
            tween<Float>(durationMillis = animationDuration, easing = FastOutSlowInEasing)
            pagerState.animateScrollToPage(page = nextPage, pageOffsetFraction = 0f)
            delay(delay) // Adjust this value to control the time between auto-scrolls
        }
    }

    Box(
        modifier =
        Modifier.background(MaterialTheme.colors.background).fillMaxWidth().height(516.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.align(Alignment.Center),
            pageCount = size
        ) { page ->
            content(page)
        }
    }
}