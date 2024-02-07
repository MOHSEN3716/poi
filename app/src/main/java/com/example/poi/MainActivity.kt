package com.example.poi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.poi.Viewmodel.mainviewmodel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var mainviewmodel = ViewModelProvider(this).get(mainviewmodel::class.java)
        mainviewmodel.gettodos()
        mainviewmodel.todosLiveData.observe(this, Observer {
            it.forEach {

                Log.d("tagx", "onCreat:${it.title}")
            }
        })

    }
}