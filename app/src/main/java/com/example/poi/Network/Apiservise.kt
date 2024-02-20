package com.example.poi.Network

import com.example.poi.Model.todos
import retrofit2.Call
import retrofit2.http.GET

interface Apiservise {
    @GET("todos")
    fun gettodos():Call<ArrayList<todos>>
}