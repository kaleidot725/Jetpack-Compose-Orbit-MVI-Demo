package jp.kaleidot725.orbit.domain.usecase

import jp.kaleidot725.orbit.data.repository.ConfigRepository
import jp.kaleidot725.orbit.data.repository.PokemonRepository

class FetchAllPokemonUseCase(
    private val pokemonRepository: PokemonRepository,
    private val configRepository: ConfigRepository
) {
    suspend operator fun invoke() {
        if (!configRepository.createdDatabase) {
            pokemonRepository.fetch()
            configRepository.createdDatabase = true
        }
    }
}