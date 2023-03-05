package com.nahuelvalencia.home.data.di

import com.nahuelvalencia.home.data.datasource.CharactersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal class CharactersApiModule {

    @Provides
    fun providesCharacterApi(
        retrofit: Retrofit
    ): CharactersApi = retrofit.create(CharactersApi::class.java)

}
