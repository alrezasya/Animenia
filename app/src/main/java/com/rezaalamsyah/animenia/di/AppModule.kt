package com.rezaalamsyah.animenia.di

import com.rezaalamsyah.animenia.ui.detail.AnimeDetailViewModel
import com.rezaalamsyah.animenia.ui.home.HomeViewModel
import com.rezaalamsyah.core.domain.usecase.AnimeInteractor
import com.rezaalamsyah.core.domain.usecase.AnimeUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<AnimeUseCase> { AnimeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { AnimeDetailViewModel(get()) }
}