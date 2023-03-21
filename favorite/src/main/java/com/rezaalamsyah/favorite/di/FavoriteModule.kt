package com.rezaalamsyah.favorite.di

import com.rezaalamsyah.favorite.ui.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favModule = module {
    viewModel { FavoriteViewModel(get()) }
}