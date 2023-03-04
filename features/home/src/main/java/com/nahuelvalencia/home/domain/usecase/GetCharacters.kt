package com.nahuelvalencia.home.domain.usecase

import arrow.core.Either
import com.nahuelvalencia.home.domain.model.MarvelCharacter
import com.nahuelvalencia.home.domain.repository.CharactersRepository
import com.nahuelvalencia.network.error.NetworkError
import javax.inject.Inject

class GetCharacters @Inject constructor(
    private val repository: CharactersRepository
) {

    suspend operator fun invoke(): Either<NetworkError, List<MarvelCharacter>> = repository.getCharacters()

}
