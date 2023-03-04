package com.nahuelvalencia.home.data.di

import com.nahuelvalencia.home.data.datasource.CharactersApi
import com.nahuelvalencia.home.data.datasource.CharactersDataSource
import com.nahuelvalencia.network.di.IoDispatcher
import com.nahuelvalencia.network.handler.ApiCallHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
internal class CharactersDataSourceModule {

    @Provides
    fun providesCharacterDataSource(
        api: CharactersApi,
        apiCallHandler: ApiCallHandler,
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher
    ): CharactersDataSource = CharactersDataSource(api, apiCallHandler, coroutineDispatcher)

}
