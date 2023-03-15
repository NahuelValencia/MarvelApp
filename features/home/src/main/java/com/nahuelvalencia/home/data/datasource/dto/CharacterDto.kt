package com.nahuelvalencia.home.data.datasource.dto

import com.nahuelvalencia.home.domain.model.MarvelCharacter
import com.squareup.moshi.JsonClass

private const val IMAGE_SIZE = "portrait_xlarge"

@JsonClass(generateAdapter = true)
internal data class CharacterDto(
    val id: Long,
    val name: String,
    val thumbnail: ThumbnailDto
) {
    fun toDomain() = MarvelCharacter(
        id = id,
        name = name,
        image = createImageUrl(thumbnail)
    )

    private fun createImageUrl(thumbnail: ThumbnailDto): String {
        val secureUrl = thumbnail.path.replace("http://", "https://")
        return "$secureUrl/$IMAGE_SIZE.${thumbnail.extension}"
    }

}
