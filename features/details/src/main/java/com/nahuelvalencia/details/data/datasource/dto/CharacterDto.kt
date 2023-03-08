package com.nahuelvalencia.details.data.datasource.dto

import com.nahuelvalencia.details.domain.model.Category
import com.nahuelvalencia.details.domain.model.Character
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class CharacterDto(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnail: ThumbnailDto,
    val comics: Comic,
    val series: Series,
    val stories: Story,
    val events: Event
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
        //TODO take into account device size and set the size url. Should be done on domain module?
        //https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/portrait_xlarge.jpg
        val secureUrl = thumbnail.path.replace("http://", "https://")
        return "$secureUrl/landscape_large.${thumbnail.extension}"
    }
}

@JsonClass(generateAdapter = true)
internal data class Comic(
    val available: Int
)

@JsonClass(generateAdapter = true)
internal data class Series(
    val available: Int
)

@JsonClass(generateAdapter = true)
internal data class Story(
    val available: Int
)

@JsonClass(generateAdapter = true)
internal data class Event(
    val available: Int
)
