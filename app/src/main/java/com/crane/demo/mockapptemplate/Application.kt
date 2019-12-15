package com.crane.demo.mockapptemplate

import android.app.Application
import com.crane.mockapp.core.MockApp
import com.crane.mockapp.core.model.layouts.AssetsProjectSource
import com.crane.mockapp.core.model.layouts.ProjectSource

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        ProjectSource.init(AssetsProjectSource(this))
    }
}