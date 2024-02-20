package com.example.poi.Repository

import com.example.poi.Network.Apiservise
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    fun getredrofit():Retrofit?{
        var retrofit:Retrofit?=null
        if (retrofit ==null){

            retrofit=Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit
    }
    var service = getredrofit()?.create(Apiservise::class.java)
    var gettodos = service?.gettodos()
}