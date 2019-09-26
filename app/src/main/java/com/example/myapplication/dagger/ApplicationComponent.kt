package com.example.myapplication.dagger

import com.example.myapplication.viewmodel.MainAvtivityViewModel
import dagger.Component
import android.app.Application
import com.example.myapplication.persistence.AppDatabase
import com.example.myapplication.persistence.dao.userDao


@Component(modules = [RepositaryModule::class])
interface ApplicationComponent {


fun inject(mainAvtivityViewModel: MainAvtivityViewModel)


    fun userDao(): userDao


    fun database(): AppDatabase

    fun application(): Application


}