package com.example.poi.Viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poi.Repository.Repository
import com.example.poi.Model.todos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

    class mainviewmodel: ViewModel() {
    
        val repository = Repository()
    
        val todosLiveData= MutableLiveData<ArrayList<todos>>()
    
        fun gettodos(){
    
            repository.gettodos?.enqueue(object : Callback<ArrayList<todos>> {
                override fun onResponse(
                    call: Call<ArrayList<todos>>,
                    response: Response<ArrayList<todos>>
                ) {
                    todosLiveData.postValue(response.body())
    
                }
    
                override fun onFailure(call: Call<ArrayList<todos>>, t: Throwable) {
                    Log.d("TAGX","onFailure")
                }
    
            })
    
        }
}
