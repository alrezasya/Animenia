package com.rezaalamsyah.core.data.source.remote.network

import com.rezaalamsyah.core.data.source.remote.response.AnimeResponse
import com.rezaalamsyah.core.data.utils.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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