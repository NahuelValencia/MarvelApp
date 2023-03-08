package com.nahuelvalencia.details.domain.repository

import arrow.core.Either
import com.nahuelvalencia.details.domain.model.Character
import com.nahuelvalencia.network.error.NetworkError

interface CharacterRepository {

    suspend fun getCharacterById(id: Long): Either<NetworkError, Character>

}
