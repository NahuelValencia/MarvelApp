package com.nahuelvalencia.home.data.datasource

import com.nahuelvalencia.home.data.datasource.dto.CharacterDto
import com.nahuelvalencia.models.dto.MarvelResponseDto
import retrofit2.http.GET

internal interface CharactersApi {

    @GET("v1/public/characters")
    suspend fun getCharacters(): MarvelResponseDto<CharacterDto>

}
