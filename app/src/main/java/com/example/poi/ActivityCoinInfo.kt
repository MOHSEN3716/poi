package com.example.poi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.poi.Model.CoinChart
import com.example.poi.Viewmodel.CoinChartViewModel
import com.example.poi.Viewmodel.CoinsViewModel
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.entryOf
import com.patrykandpatrick.vico.views.chart.ChartView
import kotlin.random.Random

class ActivityCoinInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_info)

        val CoinChartViewModel = ViewModelProvider(this).get(CoinChartViewModel::class.java)
        val chart =  CoinChartViewModel.Chart()


        fun getRandomEntries() = List(30) { entryOf(12,12)}



        val chartEntryModelProducer = ChartEntryModelProducer(getRandomEntries())
        findViewById<ChartView>(R.id.chart_view).entryProducer = chartEntryModelProducer

        chartEntryModelProducer.setEntries(getRandomEntries())



    }
}