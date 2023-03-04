package com.nahuelvalencia.home.data.datasource.dto

internal class ResponseDto(
    val code: Int,
    val message: String?,
    val copyright: String?,
    val attributionText: String?,
    val etag: String?,
    val data: PaginatedResponseDto?
)

internal class PaginatedResponseDto(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharacterDto>
)