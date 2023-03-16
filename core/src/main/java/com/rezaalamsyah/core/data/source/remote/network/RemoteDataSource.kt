package com.rezaalamsyah.core.data.source.remote.network

import android.util.Log
import com.rezaalamsyah.core.data.utils.ResponseState
import com.rezaalamsyah.core.data.source.remote.response.AnimeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getAnimeList(): Flow<ResponseState<List<AnimeResponse>?>> {
        return flow {
            try {
                val response = apiClient.getTopAnimeList()
                val data = response.listData
                if (data?.isNotEmpty() == true){
                    emit(ResponseState.Success(response.listData))
                } else {
                    emit(ResponseState.Empty)
                }
            } catch (e : Exception){
                emit(ResponseState.Failure(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}