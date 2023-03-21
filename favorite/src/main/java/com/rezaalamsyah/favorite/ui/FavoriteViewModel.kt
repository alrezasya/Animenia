package com.rezaalamsyah.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaalamsyah.core.domain.usecase.AnimeUseCase

class FavoriteViewModel(useCase: AnimeUseCase) : ViewModel() {

    val favoriteAnime = useCase.getFavoritedAnime().asLiveData()

}