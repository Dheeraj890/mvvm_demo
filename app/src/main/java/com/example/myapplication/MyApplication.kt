package com.example.myapplication

import android.app.Application
import android.content.Context
import com.example.myapplication.dagger.AppModule
import com.example.myapplication.dagger.ApplicationComponent
import com.example.myapplication.dagger.DaggerApplicationComponent
import com.example.myapplication.dagger.RoomModule

class MyApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        applicationComponent = DaggerApplicationComponent.builder().appModule(AppModule(this)).roomModule(
            RoomModule(this)
        ).build()

    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }

}