package jp.kaleidot725.orbit.domain.usecase

import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.data.repository.PokemonRepository

class LoadPokemonRevolutionUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(id: Int): List<PokemonDetails> {
        val details = pokemonRepository.getById(id) ?: return emptyList()
        val prevNumbers = details.prevEvolutions.map { it.num }
        val nextNumbers = details.nextEvolutions.map { it.num }
        val allNumbers = prevNumbers + details.pokemon.num + nextNumbers
        return pokemonRepository.getByNumbers(allNumbers)
    }
}