package com.example.poi.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poi.Repository.CriptoRepository
import com.example.poi.Model.Article
import com.example.poi.Model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CriptoViewModel : ViewModel() {

    val CriptoRepository = CriptoRepository()

    val NewsLiveData = MutableLiveData<ArrayList<Article>>()

    fun getCripto() {

        CriptoRepository.getCripto?.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                NewsLiveData.postValue(response.body()?.Arrayarticles)
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
            }
        })
    }
}