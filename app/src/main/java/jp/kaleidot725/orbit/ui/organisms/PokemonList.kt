package jp.kaleidot725.orbit.ui.organisms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.SAMPLE_POKEMON_DETAILS_LIST
import jp.kaleidot725.orbit.ui.molecules.PokemonTwoCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonList(
    detailsList: List<PokemonDetails>,
    onClickedItem: ((id: Int) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        val columns = if (detailsList.count() <= 2) {
            listOf(detailsList)
        } else {
            detailsList.windowed(size = 2, step = 2)
        }
        columns.forEach { column ->
            val one = column.getOrNull(0)
            val two = column.getOrNull(1)
            PokemonTwoCard(
                one = one,
                onClickedOne = { one?.let { onClickedItem?.invoke(it.pokemon.id) } },
                two = two,
                onClickedTwo = { two?.let { onClickedItem?.invoke(it.pokemon.id) } },
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun PokemonList_Preview() {
    PokemonList(detailsList = SAMPLE_POKEMON_DETAILS_LIST)
}