package ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import font


val montserratRegular: FontFamily
    @Composable
    get() = FontFamily(
        font(
            "Montserrat", "montserrat_regular", FontWeight.Normal, FontStyle.Normal
        )
    )

val montserratSemiBold: FontFamily
    @Composable
    get() = FontFamily(
        font(
            "Montserrat", "montserrat_semibold", FontWeight.Normal, FontStyle.Normal
        )
    )

val montserratBold: FontFamily
    @Composable
    get() = FontFamily(
        font(
            "Montserrat", "montserrat_bold", FontWeight.Normal, FontStyle.Normal
        )
    )

val TMDBAppTypography: Typography
    @Composable
    get() = Typography(
        h1 = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 52.sp,
        ),
        h2 = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        h3 = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        h4 = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        ),
        h5 = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        ),
        h6 = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
        ),
        subtitle1 = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        ),
        subtitle2 = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
        ),
        body1 = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        body2 = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontSize = 10.sp
        ),
        button = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        ),
        caption = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Normal,
            fontSize = 8.sp
        ),
        overline = TextStyle(
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    )

