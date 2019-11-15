package com.example.myapplication.repository

import com.example.myapplication.persistence.AppDatabase
import javax.inject.Inject
import javax.inject.Singleton
import androidx.lifecycle.LiveData
import com.example.myapplication.persistence.dao.WordDao
import com.example.myapplication.persistence.entity.WordEntity
import android.os.AsyncTask
import android.os.AsyncTask.execute






@Singleton
 class WordRepository {

      var  mWordDao: WordDao? = null
     var mAllWords: LiveData<List<WordEntity>>? = null

    @Inject
    lateinit var appDatabase: AppDatabase

    init {

        mWordDao=appDatabase.wordDao()

        mAllWords= mWordDao!!.getAllWords()

    }


    @Inject
     constructor()

    fun getAllWords(): LiveData<List<WordEntity>>? {
        return mAllWords
    }


    fun insert(word: WordEntity) {
        mWordDao?.let { insertAsyncTask(it).execute(word) }
    }

    private class insertAsyncTask  constructor(private val mAsyncTaskDao: WordDao) :
        AsyncTask<WordEntity, Void, Void>() {

        override fun doInBackground(vararg params: WordEntity): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }

}

