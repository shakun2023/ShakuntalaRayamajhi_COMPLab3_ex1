package com.shakuntala.rayamajhi.ex1.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import com.shakuntala.rayamajhi.ex1.model.WeatherResponse

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): WeatherResponse
}
