package com.nahuelvalencia.details.utils

import com.nahuelvalencia.network.handler.ApiCallHandler
import com.squareup.moshi.Moshi
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val client = OkHttpClient.Builder()
    .build()

private val moshi: Moshi = Moshi.Builder().build()

private val factory: MoshiConverterFactory = MoshiConverterFactory.create(moshi)

fun retrofit(baseUrl: HttpUrl): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(factory)
        .build()

fun apiCallHandler(): ApiCallHandler = ApiCallHandler()
