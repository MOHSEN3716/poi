package com.example.poi.tenwork

import com.example.poi.model.Coins
import retrofit2.Call
import retrofit2.http.GET

interface ApiCoins {
    @GET("coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false&locale=en")
    fun getCoins(): Call<ArrayList<Coins>>


}