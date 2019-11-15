package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.repository.WordRepository
import javax.inject.Inject
import androidx.lifecycle.LiveData
import com.example.myapplication.MyApplication
import com.example.myapplication.persistence.entity.WordEntity


class WordsActivityViewModel: AndroidViewModel(Application()) {

     val mAllWords: LiveData<List<WordEntity>>? = null

    //@Inject
    var word_repo: WordRepository? =null;


    init {

        // repository=MainActivityRepository.getInstance()
        var init_dagger = MyApplication.instance.applicationComponent.inject(this)


    }

    fun getAllWords(): LiveData<List<WordEntity>>? {
        return mAllWords
    }

    fun insert(word: WordEntity) {
        word_repo!!.insert(word)
    }





}