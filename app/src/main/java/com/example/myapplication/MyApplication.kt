package com.example.myapplication

import android.app.Application
import android.content.Context
import com.example.myapplication.dagger.ApplicationComponent
import com.example.myapplication.dagger.DaggerApplicationComponent

class MyApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        applicationComponent = DaggerApplicationComponent.create()

    }

    companion object {
        lateinit var instance: Application
            private set
    }

}