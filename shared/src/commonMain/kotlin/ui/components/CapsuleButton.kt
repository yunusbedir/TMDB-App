package ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CapsuleButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    contentColor: Color,
    borderStroke: BorderStroke? = null,
    content: @Composable RowScope.() -> Unit,
    onClick: () -> Unit
) {

    OutlinedButton(
        modifier = modifier,
        shape = RoundedCornerShape(50.dp),
        content = content,
        onClick = onClick,
        border = borderStroke,
        contentPadding = PaddingValues(0.dp),
        colors =
        ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor, contentColor = contentColor
        )
    )
}