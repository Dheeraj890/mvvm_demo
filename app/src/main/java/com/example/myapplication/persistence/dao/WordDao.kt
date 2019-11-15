package com.example.myapplication.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.persistence.entity.WordEntity

@Dao
interface WordDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word: WordEntity)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<WordEntity>>
}