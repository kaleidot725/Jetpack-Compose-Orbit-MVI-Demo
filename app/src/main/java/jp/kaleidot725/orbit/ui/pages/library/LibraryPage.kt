package jp.kaleidot725.orbit.ui.pages.library

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.common.UiStatus
import jp.kaleidot725.orbit.ui.molecules.*
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
            TopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        },
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        SearchBar(
                            searchText = state.searchText,
                            onChangedSearchText = { viewModel.searchPokemon(it) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }

                    if (state.status == UiStatus.Success) {
                        setupTwoGrid(state.detailsList) { one, two ->
                            PokemonTwoCard(
                                one = one,
                                onClickedOne = { one?.let { onShowDetail.invoke(it.pokemon.id) } },
                                two = two,
                                onClickedTwo = { two?.let { onShowDetail.invoke(it.pokemon.id) } },
                                modifier = Modifier
                                    .height(150.dp)
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp)
                                    .padding(bottom = 8.dp)
                            )
                        }
                    }
                }

                when (state.status) {
                    UiStatus.Loading -> {
                        LoadingIndicator(modifier = Modifier.fillMaxSize())
                    }
                    is UiStatus.Failed -> {
                        ErrorMessage(
                            message = state.status.message,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    else -> Unit
                }
            }
        }
    )
}

private fun LazyListScope.setupTwoGrid(
    entities: List<PokemonDetails>,
    row: @Composable (one: PokemonDetails?, two: PokemonDetails?) -> Unit
) {
    val rowData = if (entities.count() <= 2) {
        listOf(entities)
    } else {
        entities.windowed(size = 2, step = 2)
    }

    rowData.forEach { column ->
        item { row(column.getOrNull(0), column.getOrNull(1)) }
    }
}
