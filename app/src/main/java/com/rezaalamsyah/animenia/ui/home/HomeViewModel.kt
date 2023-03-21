package com.rezaalamsyah.animenia.ui.home

import androidx.lifecycle.ViewModel
import com.rezaalamsyah.core.domain.usecase.AnimeUseCase
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(useCase: AnimeUseCase) : ViewModel() {

    val animeResult = useCase.getAnimeList().asLiveData()

}