package com.example.myapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.model.User
import com.example.myapplication.persistence.entity.UserEntity
import com.example.myapplication.viewmodel.MainAvtivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context.NOTIFICATION_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.app.NotificationManager
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {

    private lateinit var  viewModel:MainAvtivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObservers()
        initListeners(this)

    }

    private fun initListeners(mainActivity: MainActivity) {

        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //Your code here

                viewModel.saveUserData(editText.text.toString(),editText2.text.toString())


            }})


        button2.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //Your code here

                viewModel.getAllUsers()


            }})
    }

    private fun initObservers() {
            viewModel= ViewModelProviders.of(this)[MainAvtivityViewModel::class.java]

        viewModel.getUser().observe(this, Observer<List<UserEntity>>{ users ->




            Toast.makeText(this,""+users.size,Toast.LENGTH_SHORT).show()




        })



    }
}
