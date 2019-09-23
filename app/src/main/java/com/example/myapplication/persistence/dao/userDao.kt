package com.example.myapplication.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.persistence.entity.UserEntity

@Dao
interface userDao {

    @Query("SELECT * FROM UserEntity")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserEntity>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +"last_name LIKE :last LIMIT 1")
     fun findByName(first: String, last: String): UserEntity

     @Insert
     fun insertAll(vararg users: UserEntity)

     @Delete
    fun delete(user: UserEntity)




}