package com.nahuelvalencia.details.data

internal class BaseResponseDto(
    val code: Int,
    val message: String?,
    val copyright: String?,
    val etag: String?,
    val data: ResponseDto?
)

internal class ResponseDto(
    val results: List<CharacterDto>
)