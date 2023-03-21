package com.rezaalamsyah.core.di

import com.rezaalamsyah.core.data.repository.AnimeRepository
import com.rezaalamsyah.core.data.source.db.LocalDataSource
import com.rezaalamsyah.core.data.source.remote.network.RemoteDataSource
import com.rezaalamsyah.core.domain.repository.IAnimeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<IAnimeRepository> {
        AnimeRepository(
            get(),
            get()
        )
    }
}