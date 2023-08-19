package com.yunusbedir.tmdbapp

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext

class TMDBApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(applicationContext)
        }
    }
}