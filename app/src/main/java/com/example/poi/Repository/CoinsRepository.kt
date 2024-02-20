package com.example.poi.Repository

import com.example.poi.Network.ApiCoins
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinsRepository {
    fun getRetrifit(): Retrofit? {
        var retrofit:Retrofit?=null
        if (retrofit ==null){
            retrofit=Retrofit.Builder()
                .baseUrl("https://api.coingecko.com/api/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit

    }
    var service = getRetrifit()?.create(ApiCoins::class.java)
    var getCoins = service?.getCoins()
}