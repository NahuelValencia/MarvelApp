package com.nahuelvalencia.home.domain.repository

import arrow.core.Either
import com.nahuelvalencia.home.domain.model.MarvelCharacter
import com.nahuelvalencia.network.error.NetworkError

interface CharactersRepository {

    suspend fun getCharacters(): Either<NetworkError, List<MarvelCharacter>>

}
