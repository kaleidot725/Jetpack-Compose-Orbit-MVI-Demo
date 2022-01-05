package jp.kaleidot725.orbit.ui.page.library

import jp.kaleidot725.orbit.data.entity.PokemonDetails

data class PokemonLibraryState(
    val details: List<PokemonDetails> = emptyList()
)