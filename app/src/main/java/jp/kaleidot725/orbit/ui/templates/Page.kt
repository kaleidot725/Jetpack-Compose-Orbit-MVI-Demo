package jp.kaleidot725.orbit.ui.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Page(
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column {
                header()
                content()
            }
        }
    }
}

@Preview
@Composable
fun Page_Preview() {
    Page(
        header = {
            Box(
                modifier = Modifier
                    .background(color = Color.Red)
                    .height(75.dp)
                    .fillMaxWidth()
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .background(color = Color.Blue)
                    .fillMaxSize()
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp)
    )
}