package jp.kaleidot725.orbit.domain.usecase

import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.data.repository.PokemonRepository

class SearchPokemonUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(searchText: String): List<PokemonDetails> {
        return if (searchText.isEmpty()) {
            pokemonRepository.load()
        } else {
            pokemonRepository.load().filter { it.pokemon.name.contains(searchText) }
        }
    }
}