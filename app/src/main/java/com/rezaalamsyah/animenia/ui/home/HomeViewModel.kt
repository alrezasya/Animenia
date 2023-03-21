package com.rezaalamsyah.animenia.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.rezaalamsyah.core.domain.usecase.AnimeUseCase

class HomeViewModel (useCase: AnimeUseCase) : ViewModel() {
    val animeResult = useCase.getAnimeList().asLiveData()
}