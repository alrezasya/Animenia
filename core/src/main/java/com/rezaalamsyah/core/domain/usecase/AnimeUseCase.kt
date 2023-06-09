package com.rezaalamsyah.core.domain.usecase

import com.rezaalamsyah.core.data.utils.Resource
import com.rezaalamsyah.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeUseCase {
    fun getAnimeList(): Flow<Resource<List<Anime>>>
    fun getFavoritedAnime(): Flow<List<Anime>>
    suspend fun setFavoritedAnime(anime: Anime, state: Boolean)
}