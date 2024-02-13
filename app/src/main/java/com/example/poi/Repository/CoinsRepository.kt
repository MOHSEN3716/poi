package com.example.poi.Repository

import com.example.poi.tenwork.ApiCoins
import com.example.poi.tenwork.Apiservise
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CoinsRepository {
    fun getRetrifit(): Retrofit? {
        var retrofit:Retrofit?=null
        if (retrofit ==null){
            retrofit=Retrofit.Builder()
                .baseUrl("https://api.coinranking.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit

    }
    var service = getRetrifit()?.create(ApiCoins::class.java)
    var getCoins = service?.getCoins()
}