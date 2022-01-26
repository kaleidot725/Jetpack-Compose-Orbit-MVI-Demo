package jp.kaleidot725.orbit.ui.pages.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
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

    Scaffold(
        topBar = {
            Column {
                TopBar(modifier = Modifier.fillMaxWidth())

            }
        },
        content = {
            val scrollState = rememberScrollState()
            val modifier = if (state.status != UiStatus.Success) {
                Modifier.fillMaxSize()
            } else {
                Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            }

            Column(modifier = modifier) {
                SearchBar(
                    searchText = state.searchText,
                    onChangedSearchText = { viewModel.searchPokemon(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
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
        }
    )
}