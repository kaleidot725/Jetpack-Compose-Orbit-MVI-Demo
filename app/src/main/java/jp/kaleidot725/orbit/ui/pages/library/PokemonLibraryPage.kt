package jp.kaleidot725.orbit.ui.pages.library

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.ui.common.UiStatus
import jp.kaleidot725.orbit.ui.molecules.LoadingIndicator
import jp.kaleidot725.orbit.ui.molecules.SearchBar
import jp.kaleidot725.orbit.ui.organisms.PokemonList
import jp.kaleidot725.orbit.ui.templates.Page
import kotlinx.coroutines.flow.collect

@Composable
fun PokemonLibraryPage(viewModel: PokemonLibraryViewModel) {
    val state = viewModel.container.stateFlow.collectAsState().value

    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect { /** Do Nothing */ }
    }

    Page(
        header = {
            SearchBar(
                searchText = state.searchText,
                onChangedSearchText = { viewModel.search(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        },
        content = {
            when (state.status) {
                UiStatus.Loading -> {
                    LoadingIndicator(modifier = Modifier.fillMaxSize())
                }
                UiStatus.Success -> {
                    PokemonList(
                        details = state.details,
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                    )
                }
                is UiStatus.Failed -> {
                    Text(text = state.status.message)
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}