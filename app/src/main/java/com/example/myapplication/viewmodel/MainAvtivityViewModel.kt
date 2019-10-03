package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MyApplication
import com.example.myapplication.model.User
import com.example.myapplication.persistence.entity.UserEntity
import com.example.myapplication.repository.MainActivityRepository
import javax.inject.Inject

class MainAvtivityViewModel(): ViewModel() {


    private  var userData:MutableLiveData<List<UserEntity>>?=null


    @Inject
    lateinit var application:Application

    @Inject
     lateinit var  repository:MainActivityRepository

    private lateinit var init_dagger:Any





    init {

       // repository=MainActivityRepository.getInstance()
       init_dagger= MyApplication.instance.applicationComponent.inject(this)


    }

    fun getUser(): MutableLiveData<List<UserEntity>> {

        if (userData==null){

            userData=MutableLiveData()
        }

        return userData as MutableLiveData<List<UserEntity>>
    }





    fun saveUserData(name:String,password:String){

//        var user=User(name,password)
//
//        userData!!.value=user


        repository.insertUser(UserEntity(name,password))

    }



    fun getAllUsers() {


        userData!!.value=repository.getAllUser().value


    }

    override fun onCleared() {
        super.onCleared()
    }

}