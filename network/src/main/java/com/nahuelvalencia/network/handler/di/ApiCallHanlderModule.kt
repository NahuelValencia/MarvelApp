package com.nahuelvalencia.network.handler.di

import com.nahuelvalencia.network.handler.ApiCallHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApiCallHandlerModule {
    @Provides
    fun providesApiCallHandler() = ApiCallHandler()

}
