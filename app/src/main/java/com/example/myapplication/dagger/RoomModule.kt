package com.example.myapplication.dagger

import com.example.myapplication.persistence.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import androidx.room.Room
import android.app.Application
import com.example.myapplication.persistence.dao.userDao


@Module
class RoomModule {

private lateinit var appDatabase:AppDatabase


    constructor(mApplication: Application) {

        appDatabase =
            Room.databaseBuilder(mApplication, AppDatabase::class.java!!, "user_db").allowMainThreadQueries().build()

    }


    @Singleton
    @Provides
    fun providesRoomDatabase():

            AppDatabase {

        return appDatabase

    }


    @Singleton
    @Provides
    fun providesProductDao(database: AppDatabase):

            userDao {

        return database.userDao()

    }


//    @Singleton
//    @Provides
//    fun productRepository(productDao: ProductDao):
//
//            ProductRepository {
//
//        return ProductDataSource(productDao)
//
//    }


//https://medium.com/@marco_cattaneo/integrate-dagger-2-with-room-persistence-library-in-few-lines-abf48328eaeb
}