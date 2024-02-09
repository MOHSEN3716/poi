package com.example.poi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poi.Adabter.NewsAdabter
import com.example.poi.Viewmodel.CriptoViewModel

class MainActivityCripto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cripto)
        var progressBar = findViewById<ProgressBar>(R.id.progressBar)

        var recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        var NewsAdabter = NewsAdabter()
        recyclerView.adapter = NewsAdabter

        recyclerView.visibility=View.GONE
        progressBar.visibility = View.VISIBLE



        var CriptoViewModel = ViewModelProvider(this).get(CriptoViewModel::class.java)
        CriptoViewModel.getCripto()

        CriptoViewModel.NewsLiveData.observe(this, Observer{
            recyclerView.visibility=View.VISIBLE
            progressBar.visibility = View.GONE
            NewsAdabter.loadedState(it)
        })
    }
}