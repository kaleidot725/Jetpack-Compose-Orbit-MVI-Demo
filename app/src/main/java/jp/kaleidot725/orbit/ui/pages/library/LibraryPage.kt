package jp.kaleidot725.orbit.ui.pages.library

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.ui.common.UiStatus
import jp.kaleidot725.orbit.ui.molecules.ErrorMessage
import jp.kaleidot725.orbit.ui.molecules.LoadingIndicator
import jp.kaleidot725.orbit.ui.molecules.SearchBar
import jp.kaleidot725.orbit.ui.molecules.TopBar
import jp.kaleidot725.orbit.ui.organisms.PokemonList
import jp.kaleidot725.orbit.ui.templates.SearchTemplate
import kotlinx.coroutines.flow.collect

@Composable
fun LibraryPage(
    viewModel: LibraryViewModel,
    onShowDetail: (id: Int) -> Unit
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    LaunchedEffect(viewModel) {
        viewModel.container.sideEffectFlow.collect {
            when (it) {
                is LibrarySideEffect.ShowDetails -> onShowDetail(it.id)
            }
        }
    }

    SearchTemplate(
        titleBar = {
            TopBar(modifier = Modifier.fillMaxWidth())
        },
        searchBar = {
            SearchBar(
                searchText = state.searchText,
                onChangedSearchText = { viewModel.searchPokemon(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        },
        searchContent = {
            when (state.status) {
                UiStatus.Loading -> {
                    LoadingIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 80.dp)
                    )
                }
                is UiStatus.Failed -> {
                    ErrorMessage(
                        message = state.status.message,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 80.dp)
                    )
                }
                UiStatus.Success -> {
                    PokemonList(
                        detailsList = state.detailsList,
                        onClickedItem = { viewModel.showDetails(it) },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    )
}