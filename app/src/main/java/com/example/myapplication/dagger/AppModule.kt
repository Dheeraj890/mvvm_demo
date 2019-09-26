package com.example.myapplication.dagger

import android.app.Application
import dagger.Module
import javax.inject.Singleton
import dagger.Provides


@Module
class AppModule {


   lateinit var mApplication: Application


    fun AppModule(application: Application) {

        mApplication = application

    }


    @Provides
    @Singleton
    fun providesApplication():

            Application {

        return mApplication

    }

}