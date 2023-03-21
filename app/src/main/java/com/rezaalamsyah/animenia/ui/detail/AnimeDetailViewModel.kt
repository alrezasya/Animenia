package com.rezaalamsyah.animenia.ui.detail

import androidx.lifecycle.ViewModel
import com.rezaalamsyah.core.domain.model.Anime
import com.rezaalamsyah.core.domain.usecase.AnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val useCase: AnimeUseCase) : ViewModel() {

    suspend fun setFavoriteAnime(anime: Anime, status:Boolean) =
        useCase.setFavoritedAnime(anime, status)
}