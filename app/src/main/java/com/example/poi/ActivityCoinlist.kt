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
import com.example.poi.Adabter.CoinAdabter
import com.example.poi.Adabter.NewsAdabter
import com.example.poi.Viewmodel.CoinsViewModel
import com.example.poi.Viewmodel.CriptoViewModel

class ActivityCoinlist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coinlist)
        var btnHome2 = findViewById<Button>(R.id.btnHome2)
        btnHome2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        var progressBarCoin = findViewById<ProgressBar>(R.id.progressBarCoin)
        var recyclerViewCoin = findViewById<RecyclerView>(R.id.recyclerViewCoin)
        recyclerViewCoin.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        var CoinAdabter = CoinAdabter()
        recyclerViewCoin.adapter = CoinAdabter
        recyclerViewCoin.visibility = View.INVISIBLE
        progressBarCoin.visibility = View.VISIBLE


        var CoinsViewModell = ViewModelProvider(this).get(CoinsViewModel::class.java)
        CoinsViewModell.getCoins()


        CoinsViewModell.CoinsLivedata.observe(this, Observer {
            recyclerViewCoin.visibility = View.VISIBLE
            progressBarCoin.visibility = View.INVISIBLE
            Log.d("asd","${it.get(0).name}")
            CoinAdabter.loadedState(it)


        })
    }
}