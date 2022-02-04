package jp.kaleidot725.orbit.data.repository

import jp.kaleidot725.orbit.data.dao.ImageDao
import jp.kaleidot725.orbit.data.dao.MultiplierDao
import jp.kaleidot725.orbit.data.dao.NextEvolutionDao
import jp.kaleidot725.orbit.data.dao.PokemonDao
import jp.kaleidot725.orbit.data.dao.PrevEvolutionDao
import jp.kaleidot725.orbit.data.dao.TypeDao
import jp.kaleidot725.orbit.data.dao.WeaknessDao
import jp.kaleidot725.orbit.data.database.AppDatabase
import jp.kaleidot725.orbit.data.datasource.PokemonDataSource
import jp.kaleidot725.orbit.data.dto.PokemonDto
import jp.kaleidot725.orbit.data.entity.ImageEntity
import jp.kaleidot725.orbit.data.entity.MultiplierEntity
import jp.kaleidot725.orbit.data.entity.NextEvolutionEntity
import jp.kaleidot725.orbit.data.entity.PokemonDetails
import jp.kaleidot725.orbit.data.entity.PokemonEntity
import jp.kaleidot725.orbit.data.entity.PrevEvolutionEntity
import jp.kaleidot725.orbit.data.entity.TypeEntity
import jp.kaleidot725.orbit.data.entity.WeaknessEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream

class PokemonRepository(
    private val pokemonDataSource: PokemonDataSource,
    private val pokemonDao: PokemonDao,
    private val multiplierDao: MultiplierDao,
    private val nextEvolutionDao: NextEvolutionDao,
    private val prevEvolutionDao: PrevEvolutionDao,
    private val typeDao: TypeDao,
    private val weaknessDao: WeaknessDao,
    private val imageDao: ImageDao,
    private val imageDirectory: String,
    private val imageClient: OkHttpClient,
    private val appDatabase: AppDatabase
) {
    suspend fun fetch(): Boolean {
        try {
            pokemonDataSource.fetchData().forEach { pokemonDto ->
                pokemonDao.insert(pokemonDto.toPokemonEntity())
                multiplierDao.insertAll(pokemonDto.toMultiplierEntities())
                nextEvolutionDao.insertAll(pokemonDto.toNextEvolutionEntities())
                prevEvolutionDao.insertAll(pokemonDto.toPrevEvolutionEntities())
                typeDao.insertAll(pokemonDto.toTypeEntities())
                weaknessDao.insertAll(pokemonDto.toWeaknessEntities())
                withContext(Dispatchers.IO) {
                    val localUrl = downloadImage(pokemonDto.id, pokemonDto.img)
                    if (localUrl != null) imageDao.insert(pokemonDto.toImageEntity(localUrl))
                }
            }
            return true
        } catch (e: Exception) {
            return false
        }
    }

    fun clear() {
        appDatabase.clearAllTables()
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

    private fun PokemonDto.toImageEntity(localUrl: String): ImageEntity {
        return ImageEntity(
            id = 0,
            pokemonId = this.id,
            localUrl = localUrl
        )
    }

    private suspend fun downloadImage(id: Int, remoteUrl: String?): String? {
        if (remoteUrl == null) return null

        val request = Request.Builder().url(remoteUrl).build()
        val response = imageClient.newCall(request).execute()
        val imageBytes = response.body?.bytes() ?: return null
        val file = File(imageDirectory, "$id.png")
        FileOutputStream(file).apply {
            write(imageBytes)
            close()
        }

        return file.absolutePath
    }
}
