package com.nahuelvalencia.details.data.di

import com.nahuelvalencia.details.data.datasource.CharacterDataSource
import com.nahuelvalencia.details.data.repository.CharacterRepositoryImpl
import com.nahuelvalencia.details.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class CharacterRepositoryModule {

    @Provides
    internal fun providesCharacterRepositoryModule(
        dataSource: CharacterDataSource
    ): CharacterRepository = CharacterRepositoryImpl(dataSource)

}
