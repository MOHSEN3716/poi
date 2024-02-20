package com.example.poi.Network

import com.example.poi.Model.News
import retrofit2.Call
import retrofit2.http.GET

interface Criptoapiservise{

    @GET("everything?q=iran&sortBy=popularity&apiKey=8a014570373d491fac4fd9093b89d130")
    fun getCripto():Call<News>



}
