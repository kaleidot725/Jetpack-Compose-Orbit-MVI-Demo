package jp.kaleidot725.orbit.ui.components.molecules

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import jp.kaleidot725.orbit.R
import jp.kaleidot725.orbit.ui.theme.OrbitTheme

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                textAlign = TextAlign.Left,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.h4,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun TopBar_Preview() {
    OrbitTheme {
        TopBar()
    }
}
