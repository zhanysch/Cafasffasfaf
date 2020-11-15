package com.example.sambo

import android.app.Application
import com.example.sambo.splash.PreferenceHelper

class SamboApp: Application() {

    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.initPreference(applicationContext)
        app = this
    }

    companion object{
        var app : SamboApp? = null
        private const val  DB_NAME = "MY_DB"
    }
}