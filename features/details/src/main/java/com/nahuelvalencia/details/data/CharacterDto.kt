package com.nahuelvalencia.details.data

class CharacterDto(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnailDto: ThumbnailDto,
    val comics: Comic
) {
}

data class Comic(
    val available: Int
)