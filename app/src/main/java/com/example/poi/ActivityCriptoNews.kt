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

        var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        var NewsAdabter = NewsAdabter()
        recyclerView.adapter = NewsAdabter
        recyclerView.visibility = View.INVISIBLE
        progressBar.visibility = View.VISIBLE

        var progressBarCountry=findViewById<ProgressBar>(R.id.progressBar2)
        var RecyclerViewcountry=findViewById<RecyclerView>(R.id.recyclerView2)
        RecyclerViewcountry.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        var NewsAdabtercountry = NewsCountryAdabter()
        RecyclerViewcountry.adapter =NewsAdabtercountry
        RecyclerViewcountry.visibility = View.INVISIBLE
        progressBarCountry.visibility = View.VISIBLE



        var CriptoViewModel = ViewModelProvider(this).get(CriptoViewModel::class.java)
        CriptoViewModel.getCripto()

        CriptoViewModel.NewsLiveData.observe(this, Observer {
            recyclerView.visibility = View.VISIBLE
            progressBar.visibility = View.INVISIBLE
            NewsAdabter.loadedState(it)
        })

        CriptoViewModel.getCountTryNews()

        CriptoViewModel.CountryNewsLiveData.observe(this, Observer {
            RecyclerViewcountry.visibility = View.VISIBLE
            progressBarCountry.visibility = View.INVISIBLE
            btnHome.visibility=View.VISIBLE

            Log.d("tagq","${it}")
            NewsAdabtercountry.loadedState(it)



        })


    }
}