package com.nahuelvalencia.network.handler

import arrow.core.Either
import arrow.core.right
import com.nahuelvalencia.network.error.NetworkError
import com.nahuelvalencia.network.error.networkError

/**
 * Process and handle an API call request, returns an Either by mapping the exceptions to
 * a known [NetworkError].
 */
class ApiCallHandler {

    suspend fun <T> handleResponse(
        parser: ((T) -> Either<NetworkError, T>)? = null,
        request: suspend () -> T
    ): Either<NetworkError, T> = try {
        val response = request()
        parser?.invoke(response) ?: response.right()
    } catch (throwable: Throwable) {
        throwable.networkError()
    }

}
