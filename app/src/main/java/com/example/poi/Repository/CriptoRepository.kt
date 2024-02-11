package com.example.poi.Repository

import com.example.poi.tenwork.Apiservise
import com.example.poi.tenwork.Criptoapiservise
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CriptoRepository {
    fun getredrofit(): Retrofit?{
        var retrofit: Retrofit?=null
        if (retrofit ==null){

            retrofit= Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit
    }
    var service = getredrofit()?.create(Criptoapiservise::class.java)
    var getCripto = service?.getCripto()
    var getCountTryNews=service?.getCountTryNews()


}