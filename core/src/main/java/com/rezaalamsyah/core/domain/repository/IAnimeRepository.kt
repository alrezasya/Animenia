package com.rezaalamsyah.core.domain.repository

import com.rezaalamsyah.core.data.utils.Resource
import com.rezaalamsyah.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface IAnimeRepository {

    fun getAnimeList(): Flow<Resource<List<Anime>>>

    fun getFavoritedAnime(): Flow<List<Anime>>

    fun setFavoritedAnime(anime: Anime, state: Boolean)

}