package com.nahuelvalencia.home.data.repository

import arrow.core.Either
import arrow.core.flatMap
import arrow.core.right
import com.nahuelvalencia.home.data.datasource.CharactersDataSource
import com.nahuelvalencia.home.domain.model.MarvelCharacter
import com.nahuelvalencia.home.domain.repository.CharactersRepository
import com.nahuelvalencia.network.error.NetworkError

internal class CharacterRepositoryImpl(
    private val dataSource: CharactersDataSource
) : CharactersRepository {

    override suspend fun getCharacters(): Either<NetworkError, List<MarvelCharacter>> =
        dataSource.getCharacters().mapLeft { networkError ->
            networkError //TODO: Map NetworkError to a feature specific Error
        }.flatMap { responseDto ->
            responseDto.data!!.results.map { it.toDomain() }.right()
        }

}
