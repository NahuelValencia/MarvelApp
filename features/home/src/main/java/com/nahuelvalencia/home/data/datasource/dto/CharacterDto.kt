package com.nahuelvalencia.home.data.datasource.dto

import com.nahuelvalencia.home.domain.model.MarvelCharacter

internal class CharacterDto(
    private val id: Long,
    private val name: String,
    private val description: String,
    private val thumbnail: ThumbnailDto
) {
    fun toDomain() = MarvelCharacter(
        id = id,
        name = name,
        description = description,
        image = createImageUrl(thumbnail)
    )

    private fun createImageUrl(thumbnail: ThumbnailDto): String {
        //TODO take into account device size and set the size url. Should be done on domain module?
        //https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/portrait_xlarge.jpg
        val secureUrl = thumbnail.path.replace("http://", "https://")
        return "$secureUrl/portrait_xlarge.${thumbnail.extension}"
    }
}