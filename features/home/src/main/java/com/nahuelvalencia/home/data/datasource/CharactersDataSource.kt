package com.nahuelvalencia.home.data.datasource

import arrow.core.Either
import com.nahuelvalencia.home.data.datasource.dto.CharacterDto
import com.nahuelvalencia.models.dto.MarvelResponseDto
import com.nahuelvalencia.network.error.NetworkError
import com.nahuelvalencia.network.handler.ApiCallHandler
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class CharactersDataSource(
    private val api: CharactersApi,
    private val apiCallHandler: ApiCallHandler,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend fun getCharacters(): Either<NetworkError, MarvelResponseDto<CharacterDto>> =
        withContext(coroutineDispatcher) {
            apiCallHandler.handleResponse { api.getCharacters() }
        }

}
