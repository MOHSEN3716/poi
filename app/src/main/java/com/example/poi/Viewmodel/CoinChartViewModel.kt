package com.example.poi.Viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poi.Model.CoinChart
import com.example.poi.Repository.CoinChartRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinChartViewModel: ViewModel() {
    val CoinChartRepository = CoinChartRepository()

    val CoinChartLiveData = MutableLiveData<CoinChart>()

    fun Chart() {

        CoinChartRepository.getCoinChart?.enqueue(object : Callback<CoinChart> {

            override fun onResponse(call: Call<CoinChart>, response: Response<CoinChart>) {
                CoinChartLiveData.postValue(response.body())
                Log.d("tagxp","${response.body()}")

            }

            override fun onFailure(call: Call<CoinChart>, t: Throwable) {
                Log.d("tagxp","onFailure")
            }

        })
    }
}