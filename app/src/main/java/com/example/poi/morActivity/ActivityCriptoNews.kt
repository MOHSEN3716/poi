package com.example.poi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poi.Adabter.NewsAdabter
import com.example.poi.Adabter.NewsCountryAdabter
import com.example.poi.Viewmodel.CriptoViewModel

class ActivityCriptoNews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cripto)
        var btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        btnHome.visibility=View.INVISIBLE

        var recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        var NewsAdabter = NewsAdabter()
        recyclerView.adapter = NewsAdabter
        recyclerView.visibility = View.INVISIBLE


        var CriptoViewModel = ViewModelProvider(this).get(CriptoViewModel::class.java)
        CriptoViewModel.getCripto()

        CriptoViewModel.NewsLiveData.observe(this, Observer {
            recyclerView.visibility = View.VISIBLE
            NewsAdabter.loadedState(it)
        })



    }
}