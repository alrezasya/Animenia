@file:Suppress("unused")

package com.rezaalamsyah.core.di

import com.rezaalamsyah.core.data.repository.AnimeRepository
import com.rezaalamsyah.core.domain.repository.IAnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [RemoteModule::class, DbModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(animeRepository: AnimeRepository): IAnimeRepository

}