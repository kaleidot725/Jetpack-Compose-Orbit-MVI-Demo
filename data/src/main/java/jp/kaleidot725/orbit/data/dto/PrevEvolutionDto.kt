package jp.kaleidot725.orbit.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PrevEvolutionDto(
    @SerialName("name")
    val name: String,
    @SerialName("num")
    val num: String
)
