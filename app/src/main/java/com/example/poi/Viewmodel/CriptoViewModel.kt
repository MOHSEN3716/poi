package com.example.poi.Viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poi.Repository.CriptoRepository
import com.example.poi.Repository.Repository
import com.example.poi.model.Article
import com.example.poi.model.News
import com.example.poi.model.todos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CriptoViewModel: ViewModel() {

    val CriptoRepository = CriptoRepository()

    val NewsLiveData= MutableLiveData<ArrayList<Article>>()

    fun getCripto(){

        CriptoRepository.getCripto?.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                Log.d("tagq","onResponse:${response.body()?.Arrayarticles?.get(0)?.title}")
                NewsLiveData.postValue(response.body()?.Arrayarticles)
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
            }
        })


    }


}