package jp.kaleidot725.orbit.ui.molecules

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchBar(
    searchText: String,
    onChangedSearchText: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(value = searchText, onValueChange = onChangedSearchText, modifier = modifier)
}

@Preview
@Composable
fun SearchBar_Preview() {
    SearchBar(
        searchText = "SEARCH TEXT",
        onChangedSearchText = {},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}