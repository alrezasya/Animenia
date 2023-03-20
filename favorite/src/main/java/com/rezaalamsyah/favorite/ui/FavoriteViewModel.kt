package com.rezaalamsyah.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaalamsyah.core.domain.usecase.AnimeUsecase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(useCase: AnimeUsecase) : ViewModel() {

    val favoriteAnime = useCase.getFavoritedAnime().asLiveData()

}