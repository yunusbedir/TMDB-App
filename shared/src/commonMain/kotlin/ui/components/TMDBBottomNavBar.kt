package ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab

@Composable
fun TMDBBottomNavBar(
    tabList: List<Tab>
) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp
    ) {
        tabList.onEach { tab ->
            TMDBBottomNavigationItem(tab)
        }
    }
}

@Composable
fun RowScope.TMDBBottomNavigationItem(
    tab: Tab,
    modifier: Modifier = Modifier
) {
    val tabNavigator = LocalTabNavigator.current
    val title = tab.options.title
    val selectedContentColor = LocalContentColor.current
    BottomNavigationItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = {tabNavigator.current = tab},
        icon = {
            Icon(painter = tab.options.icon!!, contentDescription = tab.options.title)
        },
        label = {
            Text(
                text = title
            )
        },
        alwaysShowLabel = false,
        interactionSource = remember { MutableInteractionSource() },
        selectedContentColor = selectedContentColor,
        unselectedContentColor = selectedContentColor.copy(alpha = ContentAlpha.medium),
        modifier = modifier
    )
}

