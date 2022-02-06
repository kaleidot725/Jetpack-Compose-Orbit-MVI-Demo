package jp.kaleidot725.orbit.ui.components.molecules

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SmallCard(
    text: String,
    modifier: Modifier = Modifier,
    backGroundColor: Color = MaterialTheme.colors.surface,
) {
    Card(
        elevation = 2.dp,
        backgroundColor = backGroundColor,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(vertical = 2.dp)
                .padding(horizontal = 8.dp)
        )
    }
}

@Preview
@Composable
private fun SmallCard_Preview() {
    SmallCard(text = "HEIGHT: TEXT", modifier = Modifier.wrapContentSize())
}