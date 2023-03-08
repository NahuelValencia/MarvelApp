package com.nahuelvalencia.home.data.datasource.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal class ThumbnailDto(
    val path: String,
    val extension: String
)