package jp.kaleidot725.orbit.ui.pages.library

import jp.kaleidot725.orbit.data.entity.PokemonDetails

data class PokemonLibraryState(
    val details: List<PokemonDetails> = emptyList()
)