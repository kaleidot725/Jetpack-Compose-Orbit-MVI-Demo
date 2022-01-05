package jp.kaleidot725.orbit.data.datasource

import android.content.Context
import jp.kaleidot725.orbit.data.dto.PokemonDto
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

class PokemonDataSource(private val context: Context) {
    @OptIn(ExperimentalSerializationApi::class)
    fun fetchData(): List<PokemonDto> {
        val inputStream = context.assets.open(FILE_NAME)
        return Json.decodeFromStream(inputStream)
    }

    companion object {
        private const val FILE_NAME = "pokedex.json"
    }
}