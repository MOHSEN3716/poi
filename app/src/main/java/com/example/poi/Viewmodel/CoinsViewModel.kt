package com.example.poi.Viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poi.Repository.CoinsRepository
import com.example.poi.Model.Coins
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinsViewModel: ViewModel()  {
    val CoinsRepository = CoinsRepository()
    val CoinsLivedata = MutableLiveData<ArrayList<Coins>>()
     fun getCoins(){
         CoinsRepository.getCoins?.enqueue(object :Callback<ArrayList<Coins>>{
             override fun onResponse(
                 call: Call<ArrayList<Coins>>,
                 response: Response<ArrayList<Coins>>
             ) {
                 Log.d("tagxp","${response.body()}")
                 CoinsLivedata.postValue(response.body())



             }

             override fun onFailure(call: Call<ArrayList<Coins>>, t: Throwable) {
                 Log.d("tagxp","onFailure")
             }
         })


         }


}