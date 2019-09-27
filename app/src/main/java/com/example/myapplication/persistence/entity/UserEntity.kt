package com.example.myapplication.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject

@Entity
 data class UserEntity(

    @ColumnInfo(name = "name") val firstName: String?,
     @ColumnInfo(name = "password") val password: String?
) {

    @PrimaryKey(autoGenerate = true) var uid: Int=0
}