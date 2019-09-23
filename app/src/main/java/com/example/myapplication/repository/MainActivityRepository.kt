package com.example.myapplication.repository

import android.app.Application
import android.os.AsyncTask
import com.example.myapplication.MyApplication
import com.example.myapplication.persistence.AppDatabase
import com.example.myapplication.persistence.entity.UserEntity

class MainActivityRepository {
    private var appDatabase: AppDatabase? = null
    private var INSTANCE:MainActivityRepository?=null



    init {

appDatabase=AppDatabase.getDatabase(MyApplication.instance)

}

fun getInstance():MainActivityRepository{

    if(INSTANCE==null){

        INSTANCE= MainActivityRepository();
    }

    return INSTANCE as MainActivityRepository
}




    fun insertUser(userEntity: UserEntity){


        appDatabase?.let { addUser(it).execute(userEntity) }

    }



    private class addUser(private var appDatabase: AppDatabase):
        AsyncTask<UserEntity, Void, Void>() {
        override fun doInBackground(vararg params: UserEntity?): Void? {
            params[0]?.let { appDatabase.userDao().insertAll(it) }

            return null

        }


    }


}