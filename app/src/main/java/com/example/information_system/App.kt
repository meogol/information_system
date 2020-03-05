package com.example.information_system

import android.app.Application
import com.vk.sdk.VKSdk

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        VKSdk.initialize(applicationContext)
    }
}