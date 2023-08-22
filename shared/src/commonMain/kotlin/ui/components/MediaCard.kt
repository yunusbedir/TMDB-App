package ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.model.result.BaseMediaModel
import ui.theme.Background
import ui.theme.TMDBAppTypography


@Composable
fun NumberMediaCard(
    index: Int,
    media: BaseMediaModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .height(200.dp)
                .width(150.dp)
                .padding(start = 16.dp, bottom = 32.dp),
            elevation = 4.dp
        ) {
            AsyncImage(
                url = media.posterPath,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

                Text(
                    text = index.toString(),
                    modifier = Modifier.align(Alignment.BottomStart)
                        .offset(
                            x = 2.dp,
                            y = 2.dp
                        ).alpha(0.50f),
                    style = TextStyle(
                        fontSize = 96.sp,
                        fontWeight = FontWeight(1000),
                        color = Color(0xFF0296E5),
                    )
                )
                Text(
                    text = index.toString(),
                    modifier = Modifier.align(Alignment.BottomStart),
                    style = TextStyle(
                        fontSize = 96.sp,
                        fontWeight = FontWeight(600),
                        color = Background,
                    )
                )
    }
}

@Composable
fun TopMediaCard(
    modifier: Modifier = Modifier,
    media: BaseMediaModel,
    onPlayClick: () -> Unit,
    onDetailsClick: () -> Unit
) {

    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
        Box {
            AsyncImage(
                url = media.posterPath,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )

            Box(
                modifier =
                Modifier.fillMaxSize()
                    .background(
                        brush =
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, MaterialTheme.colors.background),
                            startY = 0.4f * 280.dp.value
                        ),
                    ),
                contentAlignment = Alignment.BottomStart
            ) {
                Row(
                    modifier =
                    Modifier.fillMaxWidth().wrapContentHeight().padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CapsuleButton(
                        modifier = Modifier.height(30.dp).width(80.dp),
                        backgroundColor = Background,
                        contentColor = Color.LightGray,
                        onClick = onPlayClick,
                        content = {
                            Icon(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                imageVector = Icons.Rounded.PlayArrow,
                                contentDescription = "Play",
                                tint = Color.LightGray,
                            )
                            Text(
                                text = "Play",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        },
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    CapsuleButton(
                        modifier = Modifier.height(30.dp).width(80.dp),
                        backgroundColor = MaterialTheme.colors.background,
                        contentColor = Color.LightGray,
                        borderStroke = BorderStroke(1.dp, Color.LightGray),
                        onClick = onDetailsClick,
                        content = {
                            Text(
                                modifier =
                                Modifier.padding(horizontal = 2.dp)
                                    .fillMaxSize()
                                    .wrapContentSize(Alignment.Center),
                                text = "Details",
                                textAlign = TextAlign.Center,
                                color = Color.LightGray
                            )
                        },
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}

