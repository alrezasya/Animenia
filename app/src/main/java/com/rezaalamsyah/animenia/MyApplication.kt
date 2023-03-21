package com.rezaalamsyah.animenia

import android.app.Application
import com.rezaalamsyah.animenia.di.useCaseModule
import com.rezaalamsyah.animenia.di.viewModelModule
import com.rezaalamsyah.core.di.databaseModule
import com.rezaalamsyah.core.di.networkModule
import com.rezaalamsyah.core.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                module {
                    includes(
                        databaseModule,
                        networkModule,
                        repositoryModule,
                        useCaseModule,
                        viewModelModule
                    )
                }
            )
        }
    }
}