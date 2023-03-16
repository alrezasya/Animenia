package com.rezaalamsyah.core.data.source.remote.network

import com.rezaalamsyah.core.data.source.remote.response.ListAnimeResponse
import retrofit2.http.GET

interface ApiClient {
    @GET("v4/top/anime")
    suspend fun getTopAnimeList(): ListAnimeResponse
}