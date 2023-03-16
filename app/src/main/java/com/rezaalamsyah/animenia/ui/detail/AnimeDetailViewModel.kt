package com.rezaalamsyah.animenia.ui.detail

import androidx.lifecycle.ViewModel
import com.rezaalamsyah.core.domain.model.Anime
import com.rezaalamsyah.core.domain.usecase.AnimeUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val useCase: AnimeUsecase) : ViewModel() {

    fun setFavoriteAnime(anime: Anime, status:Boolean) =
        useCase.setFavoritedAnime(anime, status)
}