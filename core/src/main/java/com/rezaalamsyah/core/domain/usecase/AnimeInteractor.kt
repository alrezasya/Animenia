package com.rezaalamsyah.core.domain.usecase

import com.rezaalamsyah.core.domain.model.Anime
import com.rezaalamsyah.core.domain.repository.IAnimeRepository
import javax.inject.Inject

class AnimeInteractor @Inject constructor(private val animeRepository: IAnimeRepository): AnimeUsecase {

    override fun getAnimeList() = animeRepository.getAnimeList()

    override fun getFavoritedAnime() = animeRepository.getFavoritedAnime()

    override fun setFavoritedAnime(anime : Anime, state: Boolean) = animeRepository.setFavoritedAnime(anime, state)
}