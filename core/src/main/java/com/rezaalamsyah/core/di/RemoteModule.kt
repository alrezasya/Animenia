package com.rezaalamsyah.core.di

import com.rezaalamsyah.core.data.source.remote.network.ApiClient
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        val pinner = CertificatePinner.Builder()
            .add("api.jikan.moe", "sha256/OkKFoHjhk70gFgJbXL4o76+32oMbU9gjXDbyDfHGjLg=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .pingInterval(1, TimeUnit.SECONDS)
            .certificatePinner(pinner)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create(ApiClient::class.java)
    }
}