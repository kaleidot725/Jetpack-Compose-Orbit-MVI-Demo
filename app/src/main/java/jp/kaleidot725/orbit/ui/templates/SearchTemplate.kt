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
fun SearchTemplate(
    titleBar: @Composable () -> Unit,
    searchBar: @Composable () -> Unit,
    searchContent: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        Column(modifier = Modifier.fillMaxSize()) {
            titleBar()
            searchBar()
            searchContent()
        }
    }
}

@Preview
@Composable
private fun SearchTemplate_Preview() {
    SearchTemplate(
        titleBar = {
            Box(
                modifier = Modifier
                    .background(color = Color.Green)
                    .height(75.dp)
                    .fillMaxWidth()
            )
        },
        searchBar = {
            Box(
                modifier = Modifier
                    .background(color = Color.Red)
                    .height(75.dp)
                    .fillMaxWidth()
            )
        },
        searchContent = {
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