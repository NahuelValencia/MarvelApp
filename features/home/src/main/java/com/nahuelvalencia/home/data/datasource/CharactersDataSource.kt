package com.nahuelvalencia.home.data.datasource

import arrow.core.Either
import com.nahuelvalencia.home.data.datasource.dto.ResponseDto
import com.nahuelvalencia.network.error.NetworkError
import com.nahuelvalencia.network.handler.ApiCallHandler
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class CharactersDataSource(
    private val api: CharactersApi,
    private val apiCallHandler: ApiCallHandler,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend fun getCharacters(): Either<NetworkError, ResponseDto> =
        withContext(coroutineDispatcher) {
            apiCallHandler.handleResponse { api.getCharacters() }
        }

}
