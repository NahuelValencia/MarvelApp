package com.nahuelvalencia.details.data.di

import com.nahuelvalencia.details.data.datasource.CharacterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class CharacterApiModule {

    @Provides
    internal fun provideCharacterApi(
        retrofit: Retrofit
    ): CharacterApi = retrofit.create(CharacterApi::class.java)

}
