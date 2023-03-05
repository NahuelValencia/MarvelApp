package com.nahuelvalencia.home.data.di

import com.nahuelvalencia.home.data.datasource.CharactersDataSource
import com.nahuelvalencia.home.data.repository.CharacterRepositoryImpl
import com.nahuelvalencia.home.domain.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal class CharactersRepositoryModule {

    @Provides
    fun providesCharactersRepository(
        dataSource: CharactersDataSource
    ): CharactersRepository = CharacterRepositoryImpl(dataSource)

}
