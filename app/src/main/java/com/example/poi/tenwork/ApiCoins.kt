package com.example.poi.tenwork

import com.example.poi.model.Coinfull
import com.example.poi.model.Coins
import retrofit2.Call
import retrofit2.http.GET

interface ApiCoins {
    @GET("coins")
    fun getCoins(): Call<ArrayList<Coinfull>>


}