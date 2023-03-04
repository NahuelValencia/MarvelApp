package com.nahuelvalencia.network.di

import com.nahuelvalencia.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import javax.inject.Named

private const val BASE_URL = "https://gateway.marvel.com/"
private const val KEY = "apikey"
private const val TIMESTAMP = "ts"
private const val HASH = "hash"

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    private fun loggingInterceptorLevel() = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }

    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(loggingInterceptorLevel())


    @Provides
    fun providesOkHttpClient(
        @Named("UrlBaseConfig") urlConfig: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(urlConfig).addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Named("UrlBaseConfig")
    fun providesURLBaseConfigurationInterceptor(): Interceptor = Interceptor { chain ->
        val ts = Timestamp(System.currentTimeMillis()).time.toString()
        val md5Hash = md5("$ts${BuildConfig.PRIVATE_KEY}${BuildConfig.PUBLIC_KEY}")
        val r = chain.request().let { request ->
            request.newBuilder().url(
                request.url.newBuilder().addQueryParameter(KEY, BuildConfig.PUBLIC_KEY)
                    .addQueryParameter(TIMESTAMP, ts).addQueryParameter(HASH, md5Hash).build()
            ).build()
        }
        chain.proceed(r)
    }

    @Provides
    fun providesRetrofit(
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(converterFactory).build()

}
