package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.User

class MainAvtivityViewModel(application: Application): AndroidViewModel(application) {


    private  var userData:MutableLiveData<User>?=null


    fun getUser(): MutableLiveData<User> {

        if (userData==null){

            userData=MutableLiveData()
        }

        return userData as MutableLiveData<User>
    }



    fun saveUserData(name:String,password:String){

        var user=User(name,password)

        userData!!.value=user

    }



}