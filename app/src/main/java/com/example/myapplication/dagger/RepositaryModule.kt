package com.example.myapplication.dagger

import com.example.myapplication.persistence.AppDatabase
import com.example.myapplication.repository.WordRepository
import dagger.Module
import dagger.Provides


@Module
class RepositaryModule {



//    @Provides
//    fun provideDatabase():AppDatabase{
//
//
//
//    }


    @Provides
    fun provideWordRepository():WordRepository{

        return WordRepository()


    }



}