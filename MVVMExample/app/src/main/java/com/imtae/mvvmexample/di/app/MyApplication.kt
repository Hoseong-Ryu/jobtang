package com.imtae.mvvmexample.di.app

import android.app.Application
import com.imtae.mvvmexample.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    companion object {
        val BASE_URL = "https://api.github.com/"
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                activityModule,
                fragmentModule,
                apiModule,
                networkModule,
                appModule
            )
        }
    }
}