package com.yunusbedir.tmdbapp

import android.app.Application
import di.initKoin

class TMDBApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {

        }
    }
}