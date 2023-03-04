package com.nahuelvalencia.home.domain.usecase

import com.nahuelvalencia.home.domain.repository.CharactersRepository
import javax.inject.Inject

class GetCharacters @Inject constructor(
    private val repository: CharactersRepository
) {

    suspend operator fun invoke() = repository.getCharacters()

}
