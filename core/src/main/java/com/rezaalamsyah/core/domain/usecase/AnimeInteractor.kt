package com.rezaalamsyah.core.domain.usecase

import com.rezaalamsyah.core.domain.model.Anime
import com.rezaalamsyah.core.domain.repository.IAnimeRepository

class AnimeInteractor(private val animeRepository: IAnimeRepository): AnimeUseCase {

    override fun getAnimeList() = animeRepository.getAnimeList()

    override fun getFavoritedAnime() = animeRepository.getFavoritedAnime()

    override suspend fun setFavoritedAnime(anime : Anime, state: Boolean) = animeRepository.setFavoritedAnime(anime, state)
}