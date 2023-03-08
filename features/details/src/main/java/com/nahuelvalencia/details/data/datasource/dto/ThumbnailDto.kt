package com.nahuelvalencia.details.data.datasource.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class ThumbnailDto(
    val path: String,
    val extension: String
)
