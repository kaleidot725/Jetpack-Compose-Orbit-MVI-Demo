package jp.kaleidot725.orbit.domain.usecase

import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.data.repository.PokemonRepository

class LoadAllPokemonUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(): List<PokemonDetails> {
        return pokemonRepository.load()
    }
}