package com.example.poi.tenwork

import com.example.poi.model.Article
import com.example.poi.model.News
import com.example.poi.model.todos
import retrofit2.Call
import retrofit2.http.GET

interface Criptoapiservise{

    @GET("everything?q=bitcoin&from=2024-02-06&to=2024-02-06&sortBy=popularity&apiKey=8a014570373d491fac4fd9093b89d130")
    fun getCripto():Call<News>
}