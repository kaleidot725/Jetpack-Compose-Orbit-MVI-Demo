package jp.kaleidot725.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NextEvolutionDto(
    @SerialName("name")
    val name: String,
    @SerialName("num")
    val num: String
)