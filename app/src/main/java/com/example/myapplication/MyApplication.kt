package com.example.myapplication

import android.app.Application
import android.content.Context

class MyApplication: Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: Application
            private set
    }

}