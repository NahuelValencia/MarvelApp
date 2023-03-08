package com.nahuelvalencia.network.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class JsonSerializationFactoryModule {

    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder()
        .build()

    @Provides
    fun provideMoshiConverterFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

}
