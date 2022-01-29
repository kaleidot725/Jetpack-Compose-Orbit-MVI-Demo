package jp.kaleidot725.orbit.data.repository

import jp.kaleidot725.orbit.data.dao.*
import jp.kaleidot725.orbit.data.datasource.PokemonDataSource
import jp.kaleidot725.orbit.data.dto.PokemonDto
import jp.kaleidot725.orbit.data.entity.*

class PokemonRepository(
    private val pokemonDataSource: PokemonDataSource,
    private val pokemonDao: PokemonDao,
    private val multiplierDao: MultiplierDao,
    private val nextEvolutionDao: NextEvolutionDao,
    private val prevEvolutionDao: PrevEvolutionDao,
    private val typeDao: TypeDao,
    private val weaknessDao: WeaknessDao
) {
    suspend fun fetch() {
        // FIXME 内部DB構築済みであるか判定する処理を追加する
        if (pokemonDao.getAll().isEmpty()) {
            pokemonDataSource.fetchData().forEach { pokemonDto ->
                pokemonDao.insert(pokemonDto.toPokemonEntity())
                multiplierDao.insertAll(pokemonDto.toMultiplierEntities())
                nextEvolutionDao.insertAll(pokemonDto.toNextEvolutionEntities())
                prevEvolutionDao.insertAll(pokemonDto.toPrevEvolutionEntities())
                typeDao.insertAll(pokemonDto.toTypeEntities())
                weaknessDao.insertAll(pokemonDto.toWeaknessEntities())
            }
        }
    }

    suspend fun getAll(): List<PokemonDetails> {
        return pokemonDao.getAll()
    }

    suspend fun getById(id: Int): PokemonDetails? {
        return pokemonDao.getById(id)
    }

    suspend fun getByNumbers(numbers: List<String>): List<PokemonDetails> {
        return pokemonDao.getByNumbers(numbers)
    }

    private fun PokemonDto.toPokemonEntity(): PokemonEntity {
        return PokemonEntity(
            id = this.id,
            avgSpawns = this.avgSpawns,
            candy = this.candy ?: "",
            candyCount = this.candyCount,
            egg = this.egg ?: "",
            height = this.height ?: "",
            img = this.img ?: "",
            name = this.name ?: "",
            num = this.num ?: "",
            spawnChance = this.spawnChance,
            spawnTime = this.spawnTime ?: "",
            weight = this.weight ?: "",
        )
    }

    private fun PokemonDto.toMultiplierEntities(): List<MultiplierEntity> {
        return this.multipliers?.map { multiplier ->
            MultiplierEntity(
                id = 0,
                pokemonId = this.id,
                value = multiplier
            )
        } ?: emptyList()
    }

    private fun PokemonDto.toNextEvolutionEntities(): List<NextEvolutionEntity> {
        return this.nextEvolutions?.map { nextEvolution ->
            NextEvolutionEntity(
                id = 0,
                pokemonId = this.id,
                name = nextEvolution.name,
                num = nextEvolution.num
            )
        } ?: emptyList()
    }

    private fun PokemonDto.toPrevEvolutionEntities(): List<PrevEvolutionEntity> {
        return this.prevEvolutions?.map { prevEvolution ->
            PrevEvolutionEntity(
                id = 0,
                pokemonId = this.id,
                name = prevEvolution.name,
                num = prevEvolution.num
            )
        } ?: emptyList()
    }

    private fun PokemonDto.toTypeEntities(): List<TypeEntity> {
        return this.types?.map { type ->
            TypeEntity(
                id = 0,
                pokemonId = this.id,
                value = type
            )
        } ?: emptyList()
    }

    private fun PokemonDto.toWeaknessEntities(): List<WeaknessEntity> {
        return this.weaknesses?.map { weakness ->
            WeaknessEntity(
                id = 0,
                pokemonId = this.id,
                value = weakness
            )
        } ?: emptyList()
    }
}