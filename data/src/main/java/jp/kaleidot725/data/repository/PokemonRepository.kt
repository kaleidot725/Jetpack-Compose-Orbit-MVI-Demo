package jp.kaleidot725.data.repository

import jp.kaleidot725.data.dao.*
import jp.kaleidot725.data.datasource.PokemonDataSource
import jp.kaleidot725.data.dto.PokemonDto
import jp.kaleidot725.data.entity.*

class PokemonRepository(
    private val pokemonDataSource: PokemonDataSource,
    private val pokemonDao: PokemonDao,
    private val multiplierDao: MultiplierDao,
    private val nextEvolutionDao: NextEvolutionDao,
    private val typeDao: TypeDao,
    private val weaknessDao: WeaknessDao
) {
    suspend fun fetch() {
        pokemonDataSource.fetchData().forEach { pokemonDto ->
            pokemonDao.insert(pokemonDto.toPokemonEntity())
            multiplierDao.insertAll(pokemonDto.toMultiplierEntities())
            nextEvolutionDao.insertAll(pokemonDto.toNextEvolutionEntities())
            typeDao.insertAll(pokemonDto.toTypeEntities())
            weaknessDao.insertAll(pokemonDto.toWeaknessEntities())
        }
    }

    suspend fun load(): List<PokemonDetails> {
        return pokemonDao.getAll()
    }

    private fun PokemonDto.toPokemonEntity(): PokemonEntity {
        return PokemonEntity(
            id = this.id,
            avgSpawns = this.avgSpawns,
            candy = this.candy,
            candyCount = this.candyCount,
            egg = this.egg,
            height = this.height,
            img = this.img,
            name = this.name,
            num = this.num,
            spawnChance = this.spawnChance,
            spawnTime = this.spawnTime,
            weight = this.weight
        )
    }

    private fun PokemonDto.toMultiplierEntities(): List<MultiplierEntity> {
        return this.multipliers.map { multiplier ->
            MultiplierEntity(
                id = 0,
                pokemonId = this.id,
                value = multiplier
            )
        }
    }

    private fun PokemonDto.toNextEvolutionEntities(): List<NextEvolutionEntity> {
        return this.nextEvolutions.map { nextEvolution ->
            NextEvolutionEntity(
                id = 0,
                pokemonId = this.id,
                name = nextEvolution.name,
                num = nextEvolution.num
            )
        }
    }

    private fun PokemonDto.toTypeEntities(): List<TypeEntity> {
        return this.types.map { type ->
            TypeEntity(
                id = 0,
                pokemonId = this.id,
                value = type
            )
        }
    }

    private fun PokemonDto.toWeaknessEntities(): List<WeaknessEntity> {
        return this.weaknesses.map { weakness ->
            WeaknessEntity(
                id = 0,
                pokemonId = this.id,
                value = weakness
            )
        }
    }
}