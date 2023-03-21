package com.rezaalamsyah.core.data.repository

import com.rezaalamsyah.core.data.source.db.LocalDataSource
import com.rezaalamsyah.core.data.source.remote.network.RemoteDataSource
import com.rezaalamsyah.core.data.source.remote.response.AnimeResponse
import com.rezaalamsyah.core.data.utils.NetworkBoundResource
import com.rezaalamsyah.core.data.utils.Resource
import com.rezaalamsyah.core.data.utils.ResponseState
import com.rezaalamsyah.core.domain.model.Anime
import com.rezaalamsyah.core.domain.repository.IAnimeRepository
import com.rezaalamsyah.core.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource) : IAnimeRepository {

    override fun getAnimeList(): Flow<Resource<List<Anime>>> =
        object : NetworkBoundResource<List<Anime>, List<AnimeResponse>>() {
            override fun loadFromDB(): Flow<List<Anime>> {
                return localDataSource.getAnimeList().map {
                    DataMapper.entitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Anime>?): Boolean = true

            override suspend fun createCall(): Flow<ResponseState<List<AnimeResponse>?>> =
                remoteDataSource.getAnimeList()

            override suspend fun saveCallResult(data: List<AnimeResponse>) {
                val list = DataMapper.responsesToEntities(data)
                localDataSource.insertAnimeList(list)
            }
        }.asFlow()

    override fun getFavoritedAnime(): Flow<List<Anime>> {
        return localDataSource.getFavoritedAnime().map {
            DataMapper.entitiesToDomain(it)
        }
    }

    override suspend fun setFavoritedAnime(anime: Anime, state: Boolean) {
        val entity = DataMapper.domainToEntity(anime)
        coroutineScope {
            launch(Dispatchers.IO) {
                localDataSource.setFavoritedAnime(entity, state)
            }
        }
    }
}