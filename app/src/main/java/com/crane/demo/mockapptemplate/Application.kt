package com.crane.demo.mockapptemplate

import android.app.Application
import com.crane.mockapp.core.MockApp

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        MockApp.init(this)
    }
}