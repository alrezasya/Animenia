package com.rezaalamsyah.core.data.source.db

import com.rezaalamsyah.core.data.source.db.entity.AnimeEntity
import com.rezaalamsyah.core.data.source.db.room.dao.AnimeDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val animeDao: AnimeDao) {

    fun getAnimeList(): Flow<List<AnimeEntity>> = animeDao.getAnimeList()

    fun getFavoritedAnime(): Flow<List<AnimeEntity>> = animeDao.getFavoriteAnime()

    suspend fun insertAnimeList(animeList: List<AnimeEntity>) = animeDao.insertAnimeList(animeList)

    fun setFavoritedAnime(anime: AnimeEntity, newState: Boolean) {
        anime.isFavorite = newState
        animeDao.updateFavoriteAnime(anime)
    }
}