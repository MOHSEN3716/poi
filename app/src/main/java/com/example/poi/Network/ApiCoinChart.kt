package com.example.poi.Network

import com.example.poi.Model.CoinChart
import com.example.poi.Model.Coins
import retrofit2.Call
import retrofit2.http.GET

interface ApiCoinChart {
    @GET("coins/bitcoin/market_chart?vs_currency=usd&days=30&interval=daily&precision=2")
    fun getCoinChart(): Call<ArrayList<CoinChart>>
}