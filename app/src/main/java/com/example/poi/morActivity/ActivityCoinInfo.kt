package com.example.poi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.poi.Model.CoinChart
import com.example.poi.Viewmodel.CoinChartViewModel
import com.example.poi.Viewmodel.CriptoViewModel
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.entryOf
import com.patrykandpatrick.vico.views.chart.ChartView

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