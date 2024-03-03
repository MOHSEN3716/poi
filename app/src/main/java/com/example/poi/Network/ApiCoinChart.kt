package com.example.poi.Network

import com.example.poi.Model.CoinChart
import retrofit2.Call
import retrofit2.http.GET

interface ApiCoinChart {
    @GET("coins/bitcoin/market_chart?vs_currency=usd&days=30")
    fun getCoinChart():Call<CoinChart>
}