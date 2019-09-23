package com.example.myapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.model.User
import com.example.myapplication.viewmodel.MainAvtivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

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

    }

    private fun initObservers() {
            viewModel= ViewModelProviders.of(this)[MainAvtivityViewModel::class.java]

        viewModel.getUser().observe(this, Observer<User>{ users ->


            Toast.makeText(this,""+users.userName,Toast.LENGTH_SHORT).show()

        })



    }
}
