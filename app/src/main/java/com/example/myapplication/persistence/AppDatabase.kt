package com.example.myapplication.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.persistence.dao.userDao
import com.example.myapplication.persistence.entity.UserEntity

@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
     abstract fun userDao(): userDao



     companion object {
          private var INSTANCE: AppDatabase? = null

          fun getDatabase(context: Context): AppDatabase {
               if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "user_db").allowMainThreadQueries().build()
               }
               return INSTANCE as AppDatabase
          }

          fun destroyInstance() {
               INSTANCE = null
          }
     }


}