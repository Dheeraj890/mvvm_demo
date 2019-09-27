package com.example.myapplication.dagger

import android.app.Application
import com.example.myapplication.MyApplication
import dagger.Module
import javax.inject.Singleton
import dagger.Provides


@Module
class AppModule(var application: Application) {


    var applicationInst: Application

    init {
        applicationInst = application
    }

    fun AppModule(application: Application) {

        applicationInst = application

    }


    @Provides
    @Singleton
    fun providesApplication():

            Application {

        return applicationInst

    }

}