package com.rezaalamsyah.core.di

import android.content.Context
import androidx.room.Room
import com.rezaalamsyah.core.data.source.db.room.AnimeDb
import com.rezaalamsyah.core.data.source.db.room.dao.AnimeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AnimeDb = Room.databaseBuilder(
        context,
        AnimeDb::class.java, "AnimeniaDb.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideAnimeDao(database: AnimeDb): AnimeDao = database.animeDao()
}