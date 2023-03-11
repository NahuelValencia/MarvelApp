package com.nahuelvalencia.details.utils

import com.nahuelvalencia.details.data.datasource.dto.*
import com.nahuelvalencia.models.dto.MarvelResponseDto
import com.nahuelvalencia.models.dto.PaginatedResponseDto

internal fun createCharacterDto() = CharacterDto(
    id = 35422,
    name = "Super hero name",
    description = "Hero description",
    thumbnail = createThumbnailDto(),
    comics = createComicsDto(),
    series = createSeriesDto(),
    stories = createStoriesDto(),
    events = createEventsDto()
)

internal fun createThumbnailDto() = ThumbnailDto(
    path = "https://www.somedomain.com",
    extension = "jpeg"
)

internal fun createComicsDto() = ComicDto(available = 23)

internal fun createSeriesDto() = SeriesDto(available = 2)

internal fun createEventsDto() = EventDto(available = 32)

internal fun createStoriesDto() = StoryDto(available = 0)

internal fun createMarvelResponseDto() = MarvelResponseDto<CharacterDto>(
    code = 200,
    status = "ok",
    data = PaginatedResponseDto(
        offset = 0,
        limit = 20,
        total = 134,
        count = 20,
        results = listOf(createCharacterDto())
    )
)
