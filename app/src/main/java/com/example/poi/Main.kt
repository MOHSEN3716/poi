package com.example.poi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.poi.Model.WeatherModel.WeatherApi
import com.example.poi.Network.ApiWeather
import com.example.poi.databinding.ActivityMain2Binding
import com.example.poi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Objects
import kotlin.math.log
class   Main : AppCompatActivity() {
    private val binding: ActivityMain2Binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fatachweatherData("tehran")
        searchCity()


    }

     fun searchCity() {
        val searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener  {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("SearchView", "Query submitted: $query")
                if (query != null) {
                    fatachweatherData(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("SearchView", "filed")

                return true
            }

        })

    }

    private fun fatachweatherData(cityName: String) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiWeather::class.java)
        val response =
            retrofit.getweatherData(cityName, "6f0a36cb449188ce761b1e7dca35ad9c", "matric")

        response.enqueue(object : Callback<WeatherApi> {
            override fun onResponse(call: Call<WeatherApi>, response: Response<WeatherApi>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    val temperature = responseBody.main.temp.toString()
                    val humidity = responseBody.main.humidity
                    val speed = responseBody.wind.speed
                    val sunRise = responseBody.sys.sunrise.toLong()
                    val sunSet = responseBody.sys.sunset.toLong()
                    val seaLevel = responseBody.main.pressure
                    val condition = responseBody.weather.firstOrNull()?.main ?: "unknown"
                    val maxTemp = responseBody.main.temp_max
                    val minTemp = responseBody.main.temp_min
                    binding.temp.text = "$temperature C"
                    binding.weather.text = condition
                    binding.seaLevel.text = "$seaLevel hpa"
                    binding.maxtmp.text = "$maxTemp C"
                    binding.mintmp.text = "$minTemp C"
                    binding.speed.text = "$speed m/s"
                    binding.sunset.text = "${time(sunSet)}"
                    binding.sunrise.text = "${time(sunRise)}"
                    binding.humditi.text = "$humidity"
                    binding.condition.text = condition
                    binding.data.text = getdata()
                    binding.day.text = getday(System.currentTimeMillis())
                    binding.cityname.text = "$cityName"
                    Log.d("Aloo", "onResponse$speed")
                    Changeimage(condition)


                }
            }

            override fun onFailure(call: Call<WeatherApi>, t: Throwable) {
                Log.d("Aloo", "onFailure")

            }

        })

    }

    private fun Changeimage(condition:String) {
        when (condition) {
            "Clear SKY", "Sunny", "Clear" -> {
                binding.root.setBackgroundResource(R.drawable.david_law)
                binding.lottieAnimationView.setAnimation(R.raw.animation1)
            }

            "Partly Clouds", "Clouds", "Overcast", "Mist", "foggy" -> {
                binding.root.setBackgroundResource(R.drawable.david_cloud)
                binding.lottieAnimationView.setAnimation(R.raw.animationcloude)
            }

            "Light Rain", "Drizzle", "Modeate Rain", "Showers", " Heavy Rain" -> {
                binding.root.setBackgroundResource(R.drawable.rain)
                binding.lottieAnimationView.setAnimation(R.raw.rain)
            }

            "Light Snow", "Moderate Snow", "Heavy Snow", "Blizzard" -> {
                binding.root.setBackgroundResource(R.drawable.snow)
                binding.lottieAnimationView.setAnimation(R.raw.snow)
            }

            else -> {
                binding.root.setBackgroundResource(R.drawable.david_law)
                binding.lottieAnimationView.setAnimation(R.raw.animation1)

            }
        }
        binding.lottieAnimationView.playAnimation()
    }

    //TIME
    private fun getdata ():String {
        val std = SimpleDateFormat("dd mmmm yyyy", Locale.getDefault())
        return std.format((Date()))
    }
    private fun time (timestemp:Long):String {
        val std = SimpleDateFormat("HH:mm", Locale.getDefault())
        return std.format((Date(timestemp*1000)))
    }
    fun getday(timestemp:Long):String {
        val std = SimpleDateFormat("EEEE", Locale.getDefault())
        return std.format((Date()))
    }



}