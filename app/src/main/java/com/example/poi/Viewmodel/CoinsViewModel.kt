package com.example.poi.Viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poi.Repository.CoinsRepository
import com.example.poi.model.Coinfull
import com.example.poi.model.Coins
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class CoinsViewModel: ViewModel()  {
    val CoinsRepository = CoinsRepository()
    val CoinsLivedata = MutableLiveData<ArrayList<Coins>>()
     fun getCoins(){
         CoinsRepository.getCoins?.enqueue(object :Callback<Coinfull>{
         })


         }


}