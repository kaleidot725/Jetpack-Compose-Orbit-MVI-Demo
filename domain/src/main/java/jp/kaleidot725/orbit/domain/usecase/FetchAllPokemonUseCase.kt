package jp.kaleidot725.orbit.domain.usecase

import jp.kaleidot725.orbit.data.repository.PokemonRepository

class FetchAllPokemonUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke() {
        return pokemonRepository.fetch()
    }
}