package com.example.poi.Network

import com.example.poi.Model.WeatherModel.WeatherApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWeather {
    @GET("weather")
    fun getweatherData(
        @Query("q") city:String,
        @Query("appid") appid:String,
        @Query("units") units:String
    ):Call<WeatherApi>
}