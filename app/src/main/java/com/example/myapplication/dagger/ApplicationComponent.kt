package com.example.myapplication.dagger

import com.example.myapplication.viewmodel.MainAvtivityViewModel
import dagger.Component
import android.app.Application
import com.example.myapplication.persistence.AppDatabase
import com.example.myapplication.persistence.dao.WordDao
import com.example.myapplication.persistence.dao.userDao
import com.example.myapplication.viewmodel.WordsActivityViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositaryModule::class,AppModule::class,RoomModule::class])
interface ApplicationComponent {


fun inject(mainAvtivityViewModel: MainAvtivityViewModel)

    fun inject(wordsActivityViewModel: WordsActivityViewModel)

    fun userDao(): userDao

    fun wordDao():WordDao

    fun database(): AppDatabase

    fun application(): Application


}