package com.example.myapplication.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.persistence.dao.userDao
import com.example.myapplication.persistence.entity.UserEntity
import com.example.myapplication.persistence.entity.WordEntity
import android.os.AsyncTask.execute
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.annotation.NonNull
import com.example.myapplication.persistence.dao.WordDao
import android.os.AsyncTask





@Database(entities = arrayOf(UserEntity::class,WordEntity::class), version = 2,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
     abstract fun userDao(): userDao
     abstract fun wordDao(): WordDao





     companion object {
          private var INSTANCE: AppDatabase? = null

          fun getDatabase(context: Context): AppDatabase {
               if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "user_db").allowMainThreadQueries().addCallback(AppDatabase.INSTANCE!!.sRoomDatabaseCallback).build()
               }
               return INSTANCE as AppDatabase
          }

          fun destroyInstance() {
               INSTANCE = null
          }
     }


     private val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

          override fun onOpen(db: SupportSQLiteDatabase) {
               super.onOpen(db)
               INSTANCE?.let { PopulateDbAsync(it).execute() }
          }
     }

     private class PopulateDbAsync internal constructor(db: AppDatabase) :
          AsyncTask<Void, Void, Void>() {

          private val mDao: WordDao
          internal var words = arrayOf("dolphin", "crocodile", "cobra")

          init {
               mDao = db.wordDao()
          }

          override fun doInBackground(vararg params: Void): Void? {
               // Start the app with a clean database every time.
               // Not needed if you only populate the database
               // when it is first created
               mDao.deleteAll()

               for (i in 0..words.size - 1) {
                    val word = WordEntity(words[i])
                    mDao.insert(word)
               }
               return null
          }
     }

}