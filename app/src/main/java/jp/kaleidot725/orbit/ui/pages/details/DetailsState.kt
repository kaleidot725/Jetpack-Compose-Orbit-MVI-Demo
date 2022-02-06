package jp.kaleidot725.orbit.ui.pages.details

import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.ui.common.UiStatus

data class DetailsState(
    val status: UiStatus = UiStatus.Loading,
    val details: PokemonDetails? = null,
    val evolutions: List<PokemonDetails> = emptyList()
)
