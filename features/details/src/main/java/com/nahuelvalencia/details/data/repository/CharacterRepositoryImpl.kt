package com.nahuelvalencia.details.data.repository

import arrow.core.Either
import arrow.core.flatMap
import arrow.core.right
import com.nahuelvalencia.details.data.datasource.CharacterDataSource
import com.nahuelvalencia.details.domain.model.Character
import com.nahuelvalencia.details.domain.repository.CharacterRepository
import com.nahuelvalencia.network.error.NetworkError

internal class CharacterRepositoryImpl(
    private val dataSource: CharacterDataSource
) : CharacterRepository {

    override suspend fun getCharacterById(id: Long): Either<NetworkError, Character> =
        dataSource.invoke(id = id).mapLeft { networkError ->
            networkError //TODO: Map NetworkError to a feature specific Error
        }.flatMap { marvelResponseDto ->
            marvelResponseDto.data.results.first().toDomain().right()
        }

}
