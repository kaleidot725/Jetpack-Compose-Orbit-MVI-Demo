package jp.kaleidot725.orbit.ui.molecules

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.R
import jp.kaleidot725.orbit.ui.theme.OrbitTheme

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Card(modifier = modifier, shape = RectangleShape, elevation = 4.dp) {
        Text(
            text = stringResource(id = R.string.app_name),
            textAlign = TextAlign.Left,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h4,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 12.dp)
                .padding(vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun TopBar_Preview() {
    OrbitTheme {
        TopBar()
    }
}