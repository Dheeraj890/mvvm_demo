package com.example.myapplication.persistence.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "word_table")
data class WordEntity(@PrimaryKey
                      @NonNull
                      @ColumnInfo(name = "word")
                      var  mWorde:String) {



    fun getWord(): String {
        return this.mWorde
    }
}