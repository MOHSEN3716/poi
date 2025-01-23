package com.example.poi.morActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.poi.R
import com.example.poi.Viewmodel.CoinChartViewModel

class ActivityCoinInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_info)
        var coin = CoinChartViewModel()
        coin.Chart()
        coin.CoinChartLiveData.observe(this,Observer{


        })



    }
}