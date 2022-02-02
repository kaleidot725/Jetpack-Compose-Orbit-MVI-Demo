package jp.kaleidot725.orbit.ui.pages.library

import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.common.UiStatus

data class LibraryState(
    val status: UiStatus = UiStatus.Loading,
    val searchText: String = "",
    val detailsList: List<PokemonDetails> = emptyList()
)
