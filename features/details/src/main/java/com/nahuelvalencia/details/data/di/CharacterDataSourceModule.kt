package com.nahuelvalencia.details.data.di

import com.nahuelvalencia.details.data.datasource.CharacterApi
import com.nahuelvalencia.details.data.datasource.CharacterDataSourceImpl
import com.nahuelvalencia.network.di.IoDispatcher
import com.nahuelvalencia.network.handler.ApiCallHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@InstallIn(SingletonComponent::class)
@Module
class CharacterDataSourceModule {

    @Provides
    internal fun providesCharacterDataSource(
        api: CharacterApi,
        apiCallHandler: ApiCallHandler,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): CharacterDataSourceImpl = CharacterDataSourceImpl(api, apiCallHandler, dispatcher)

}
