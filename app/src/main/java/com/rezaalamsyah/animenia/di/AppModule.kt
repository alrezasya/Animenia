package com.rezaalamsyah.animenia.di

import com.rezaalamsyah.core.domain.usecase.AnimeInteractor
import com.rezaalamsyah.core.domain.usecase.AnimeUsecase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideAnimeUseCase(interactor: AnimeInteractor): AnimeUsecase

}