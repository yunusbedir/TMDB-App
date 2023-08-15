package ui.navigation

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun TMDBBottomNavBar(
    currentScreen: ScreenDestination,
    topScreenDestinations: List<ScreenDestination>,
    navigateTo: (ScreenDestination) -> Unit
) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth()
    ) {
        topScreenDestinations.onEach { topScreenDestination ->
            TMDBBottomNavigationItem(
                selected = topScreenDestination.label == currentScreen.label,
                onClick = {
                    navigateTo.invoke(topScreenDestination)
                },
                imageVector = topScreenDestination.icon,
                label = topScreenDestination.label
            )
        }
    }
}

@Composable
fun RowScope.TMDBBottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    imageVector: ImageVector?,
    label: String,
    modifier: Modifier = Modifier
) {
    val selectedContentColor = LocalContentColor.current
    BottomNavigationItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                imageVector = imageVector ?: Icons.Outlined.Refresh,
                contentDescription = label
            )
        },
        label = {
            Text(
                text = label
            )
        },
        alwaysShowLabel = false,
        interactionSource = remember { MutableInteractionSource() },
        selectedContentColor = selectedContentColor,
        unselectedContentColor = selectedContentColor.copy(alpha = ContentAlpha.medium),
        modifier = modifier
    )
}

