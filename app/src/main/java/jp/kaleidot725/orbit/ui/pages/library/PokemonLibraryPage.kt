package jp.kaleidot725.orbit.ui.pages.library

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.ui.common.UiStatus
import jp.kaleidot725.orbit.ui.molecules.LoadingIndicator
import jp.kaleidot725.orbit.ui.molecules.SearchBar
import jp.kaleidot725.orbit.ui.molecules.TopBar
import jp.kaleidot725.orbit.ui.organisms.PokemonList
import jp.kaleidot725.orbit.ui.templates.SearchTemplate
import kotlinx.coroutines.flow.collect

@Composable
fun PokemonLibraryPage(viewModel: PokemonLibraryViewModel) {
    val state = viewModel.container.stateFlow.collectAsState().value

    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect { /** Do Nothing */ }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar() },
        content = {
            SearchTemplate(
                searchBar = {
                    SearchBar(
                        searchText = state.searchText,
                        onChangedSearchText = { viewModel.search(it) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                },
                searchContent = {
                    when (state.status) {
                        UiStatus.Loading -> {
                            LoadingIndicator(modifier = Modifier.fillMaxSize())
                        }
                        is UiStatus.Failed -> {
                            Box(modifier = Modifier.fillMaxSize()) {
                                Text(
                                    text = state.status.message,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        }
                        UiStatus.Success -> {
                            PokemonList(
                                details = state.details,
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            )
        }
    )
}