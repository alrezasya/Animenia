package com.rezaalamsyah.animenia.di

import com.rezaalamsyah.core.domain.usecase.AnimeUsecase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun useCase(): AnimeUsecase
}