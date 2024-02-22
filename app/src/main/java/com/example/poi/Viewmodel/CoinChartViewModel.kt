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

    val CoinChartLiveData = MutableLiveData<ArrayList<CoinChart>>()

    fun Chart() {

        CoinChartRepository.getCoinChart?.enqueue(object : Callback<ArrayList<CoinChart>> {
            override fun onResponse(
                call: Call<ArrayList<CoinChart>>,
                response: Response<ArrayList<CoinChart>>
            ) {
                Log.d("tagxp","${response.body()}")
                CoinChartLiveData.postValue(response.body())

            }

            override fun onFailure(call: Call<ArrayList<CoinChart>>, t: Throwable) {
                Log.d("tagxp","onFailure")
            }

        })
    }
}