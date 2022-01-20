package jp.kaleidot725.orbit.ui.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.kaleidot725.orbit.R

@Composable
fun SearchBar(
    searchText: String,
    onChangedSearchText: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        TextField(
            value = searchText,
            onValueChange = onChangedSearchText,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background),
            label = { Text(stringResource(R.string.search)) }
        )
    }

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