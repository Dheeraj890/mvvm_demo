package com.example.myapplication.ui.activity

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

import kotlinx.android.synthetic.main.activity_add_word.*
import kotlinx.android.synthetic.main.content_add_word.*
import android.text.TextUtils
import android.content.Intent
import android.app.Activity




class AddWordActivity : AppCompatActivity() {

    companion object {
        val EXTRA_REPLY = "com.example.android.roomwordssample.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        button_save.setOnClickListener(View.OnClickListener {

            val word = edit_word.getText().toString()
            val replyIntent = Intent()
            if (TextUtils.isEmpty(word)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {

                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()


        })



    }

}
