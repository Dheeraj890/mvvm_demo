package com.example.myapplication.repository

import android.app.Application
import android.os.AsyncTask
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.MyApplication
import com.example.myapplication.persistence.AppDatabase
import com.example.myapplication.persistence.dao.userDao
import com.example.myapplication.persistence.entity.UserEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
 class MainActivityRepository {
    @Inject
    lateinit var appDatabase: AppDatabase

     var getAllUserEntity=MutableLiveData<List<UserEntity>>()



     @Inject
      constructor()

    init {

//appDatabase=AppDatabase.getDatabase(MyApplication.instance)

}

     companion object{
         private var INSTANCE:MainActivityRepository?=null


         fun getInstance():MainActivityRepository{

             if(INSTANCE==null){

                 INSTANCE= MainActivityRepository();
             }

             return INSTANCE as MainActivityRepository
         }


     }





    fun insertUser(userEntity: UserEntity){



        addUser(appDatabase).execute(userEntity)

    }


    fun getAllUser(): LiveData<List<UserEntity>> {

var list=appDatabase!!.userDao().getAll()

        getAllUserEntity.value=list

        return getAllUserEntity

    }



    private class addUser(private var appDatabase: AppDatabase?):
        AsyncTask<UserEntity, Void, UserEntity>() {
        override fun doInBackground(vararg params: UserEntity): UserEntity? {
         var i=  appDatabase!!.userDao().insertAll(params[0])

            return params[0]

        }


        override fun onPostExecute(result: UserEntity?) {
            super.onPostExecute(result)


            Toast.makeText(MyApplication.instance,"Success "+result?.firstName,Toast.LENGTH_SHORT).show()

        }


    }


}