package com.nahuelvalencia.details.data.datasource

import com.nahuelvalencia.details.data.datasource.dto.CharacterDto
import com.nahuelvalencia.models.dto.MarvelResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

internal interface CharacterApi {

    @GET("v1/public/characters/{id}")
    suspend fun getCharacterById(
        @Path("id") characterId: Long
    ): MarvelResponseDto<CharacterDto>

}
