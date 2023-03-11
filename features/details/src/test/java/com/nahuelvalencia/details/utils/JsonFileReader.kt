package com.nahuelvalencia.details.utils

import okio.buffer
import okio.source
import java.nio.charset.StandardCharsets

fun getJsonStringFromFile(
    resourcePath: String = "api-responses",
    fileName: String,
    classLoader: ClassLoader?
): String {
    val inputStream = classLoader?.getResourceAsStream("$resourcePath/$fileName")
    val source =
        requireNotNull(inputStream, { "Resource $resourcePath/$fileName not found." }).let {
            inputStream.source().buffer()
        }
    return source.readString(StandardCharsets.UTF_8)
}