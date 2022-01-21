package jp.kaleidot725.orbit.domain.usecase

import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.data.repository.PokemonRepository

class LoadPokemonDetailsUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(id: Int): PokemonDetails? {
        return pokemonRepository.getById(id)
    }
}