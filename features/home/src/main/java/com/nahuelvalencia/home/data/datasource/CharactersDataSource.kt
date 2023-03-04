package com.nahuelvalencia.home.data.datasource

import com.nahuelvalencia.network.handler.ApiCallHandler
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class CharactersDataSource(
    private val api: CharactersApi,
    private val apiCallHandler: ApiCallHandler,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend fun getCharacters() = withContext(coroutineDispatcher) {
        apiCallHandler.handleResponse {
            api.getCharacters()
        }
    }

}
