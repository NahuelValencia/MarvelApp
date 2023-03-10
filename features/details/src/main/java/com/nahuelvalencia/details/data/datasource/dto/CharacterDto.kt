package com.nahuelvalencia.details.data.datasource.dto

import com.nahuelvalencia.details.domain.model.Category
import com.nahuelvalencia.details.domain.model.Character
import com.squareup.moshi.JsonClass

private const val IMAGE_SIZE = "landscape_large"

@JsonClass(generateAdapter = true)
internal data class CharacterDto(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnail: ThumbnailDto,
    val comics: ComicDto,
    val series: SeriesDto,
    val stories: StoryDto,
    val events: EventDto
) {
    fun toDomain() = Character(
        id = id,
        name = name,
        description = description,
        image = createImageUrl(thumbnail),
        interestingNumbers = mutableMapOf(
            Pair(Category.COMICS, comics.available),
            Pair(Category.SERIES, series.available),
            Pair(Category.STORIES, stories.available),
            Pair(Category.EVENTS, events.available)
        )
    )

    private fun createImageUrl(thumbnail: ThumbnailDto): String {
        val secureUrl = thumbnail.path.replace("http://", "https://")
        return "$secureUrl/$IMAGE_SIZE.${thumbnail.extension}"
    }
}

@JsonClass(generateAdapter = true)
internal data class ComicDto(
    val available: Int
)

@JsonClass(generateAdapter = true)
internal data class SeriesDto(
    val available: Int
)

@JsonClass(generateAdapter = true)
internal data class StoryDto(
    val available: Int
)

@JsonClass(generateAdapter = true)
internal data class EventDto(
    val available: Int
)
