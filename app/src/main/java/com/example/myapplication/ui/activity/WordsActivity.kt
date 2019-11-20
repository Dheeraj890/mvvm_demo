package com.example.myapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.WordListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.persistence.entity.UserEntity
import com.example.myapplication.persistence.entity.WordEntity
import com.example.myapplication.viewmodel.MainAvtivityViewModel
import com.example.myapplication.viewmodel.WordsActivityViewModel
import kotlinx.android.synthetic.main.activity_words.*
import android.content.Intent
import android.app.Activity
import android.view.View




class WordsActivity : AppCompatActivity() {

    private lateinit var  viewModel:WordsActivityViewModel
    private lateinit var adapter:WordListAdapter

    val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words)
        initViews()
        initObservers()
    }

    private fun initViews() {


         adapter = WordListAdapter(this)
        recycleView.setAdapter(adapter)
        recycleView.setLayoutManager(LinearLayoutManager(this))


        floatingActionButton.setOnClickListener(View.OnClickListener {


            val intent = Intent(this@WordsActivity, AddWordActivity::class.java)
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)

        })
    }


    private fun initObservers() {
        viewModel= ViewModelProviders.of(this)[WordsActivityViewModel::class.java]

        viewModel.getAllWords()?.observe(this, Observer<List<WordEntity>>{ words ->


            adapter.setWords(words);

            Toast.makeText(this,""+words.size, Toast.LENGTH_SHORT).show()




        })



    }


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val word = WordEntity(data!!.getStringExtra(AddWordActivity!!.EXTRA_REPLY))
            viewModel.insert(word)
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
