package com.nahuelvalencia.network.error

import arrow.core.left
import com.squareup.moshi.JsonDataException
import retrofit2.HttpException
import java.io.EOFException
import java.net.ConnectException

sealed class NetworkError(val error: String) {
    data class ResourceNotFound(val message: String) : NetworkError(message)
    data class NoInternet(val message: String) : NetworkError(message)
    data class UnableToParse(val message: String) : NetworkError(message)
    data class ServerError(val message: String) : NetworkError(message)
    data class Unknown(val message: String) : NetworkError(message)
}

internal fun Throwable.networkError() = when (this) {
    is ConnectException -> NetworkError.NoInternet(localizedMessage ?: "Connection error")
    is EOFException -> NetworkError.UnableToParse(
        localizedMessage ?: "End of file/stream exception error"
    )
    is JsonDataException -> NetworkError.UnableToParse(
        localizedMessage ?: "Error parsing Json data error"
    )
    is HttpException -> networkError()
    else -> NetworkError.Unknown("Unknown error")
}.left()

fun HttpException.networkError(): NetworkError = when {
    code() == 404 -> NetworkError.ResourceNotFound(localizedMessage ?: "Resource not found")
    code() in 500..599 -> NetworkError.ServerError(localizedMessage ?: "Server error")
    else -> NetworkError.Unknown("Unknown error")
}
