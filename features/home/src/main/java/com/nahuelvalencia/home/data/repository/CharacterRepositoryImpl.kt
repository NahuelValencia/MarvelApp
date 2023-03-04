package com.nahuelvalencia.home.data.repository

import com.nahuelvalencia.home.data.datasource.CharactersDataSource
import com.nahuelvalencia.home.domain.repository.CharactersRepository

internal class CharacterRepositoryImpl(
    private val dataSource: CharactersDataSource
) : CharactersRepository {

    override suspend fun getCharacters() {
        dataSource.getCharacters()
    }

}
