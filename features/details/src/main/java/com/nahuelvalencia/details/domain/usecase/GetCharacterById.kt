package com.nahuelvalencia.details.domain.usecase

import arrow.core.Either
import com.nahuelvalencia.details.domain.model.Character
import com.nahuelvalencia.details.domain.repository.CharacterRepository
import com.nahuelvalencia.network.error.NetworkError
import javax.inject.Inject

class GetCharacterById @Inject constructor(
    private val repository: CharacterRepository
) {

    suspend operator fun invoke(characterId: Long): Either<NetworkError, Character> =
        repository.getCharacterById(id = characterId)

}
