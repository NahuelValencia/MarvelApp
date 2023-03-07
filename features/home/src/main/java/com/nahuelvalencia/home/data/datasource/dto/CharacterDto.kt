package com.nahuelvalencia.home.data.datasource.dto

import com.nahuelvalencia.home.domain.model.MarvelCharacter
import com.squareup.moshi.JsonClass

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
        //TODO take into account device size and set the size url. Should be done on domain module?
        //https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/portrait_xlarge.jpg
        val secureUrl = thumbnail.path.replace("http://", "https://")
        return "$secureUrl/portrait_xlarge.${thumbnail.extension}"
    }
}