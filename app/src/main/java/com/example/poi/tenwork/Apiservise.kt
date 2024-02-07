package com.example.poi.tenwork

import com.example.poi.model.todos
import retrofit2.Call
import retrofit2.http.GET

interface Apiservise {
    @GET("todos")
    fun gettodos():Call<ArrayList<todos>>
}