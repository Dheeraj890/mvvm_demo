package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.repository.WordRepository
import javax.inject.Inject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MyApplication
import com.example.myapplication.persistence.entity.WordEntity


class WordsActivityViewModel: ViewModel() {

     val mAllWords: LiveData<List<WordEntity>>? = null

    @Inject
    lateinit  var word_repo: WordRepository

  lateinit  var init_dagger:Any


    init {

        // repository=MainActivityRepository.getInstance()
         init_dagger = MyApplication.instance.applicationComponent.inject(this)


    }

    fun getAllWords(): LiveData<List<WordEntity>>? {
        return mAllWords
    }

    fun insert(word: WordEntity) {
        word_repo!!.insert(word)
    }





}