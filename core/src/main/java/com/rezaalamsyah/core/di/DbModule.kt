package com.rezaalamsyah.core.di

import androidx.room.Room
import com.rezaalamsyah.core.data.source.db.room.AnimeDb
import net.sqlcipher.database.SQLiteDatabase.getBytes
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<AnimeDb>().animeDao() }
    single {
        val passPhrase: ByteArray = getBytes("animenia".toCharArray())
        val factory = SupportFactory(passPhrase)
        Room.databaseBuilder(
            androidContext(),
            AnimeDb::class.java, "AnimeniaDatabase.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}