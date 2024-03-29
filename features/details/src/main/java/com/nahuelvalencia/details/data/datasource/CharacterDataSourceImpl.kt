package com.nahuelvalencia.details.data.datasource

import arrow.core.Either
import com.nahuelvalencia.details.data.datasource.dto.CharacterDto
import com.nahuelvalencia.models.dto.MarvelResponseDto
import com.nahuelvalencia.network.error.NetworkError
import com.nahuelvalencia.network.handler.ApiCallHandler
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal interface CharacterDataSource {
    suspend fun getCharacterById(id: Long): Either<NetworkError, MarvelResponseDto<CharacterDto>>
}

internal class CharacterDataSourceImpl(
    private val api: CharacterApi,
    private val apiCallHandler: ApiCallHandler,
    private val dispatcher: CoroutineDispatcher
) : CharacterDataSource {

    override suspend fun getCharacterById(id: Long): Either<NetworkError, MarvelResponseDto<CharacterDto>> =
        withContext(dispatcher) {
            apiCallHandler.handleResponse { api.getCharacterById(characterId = id) }
        }

}
