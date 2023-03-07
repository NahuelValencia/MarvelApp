package com.nahuelvalencia.models.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MarvelResponseDto<T>(
    val code: Int,
    val status: String,
    val data: PaginatedResponseDto<T>
)

@JsonClass(generateAdapter = true)
class PaginatedResponseDto<T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<T>
)
