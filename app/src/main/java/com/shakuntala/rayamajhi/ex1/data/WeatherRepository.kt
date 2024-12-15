package com.shakuntala.rayamajhi.ex1.data

import com.shakuntala.rayamajhi.ex1.data.local.WeatherDao
import com.shakuntala.rayamajhi.ex1.data.remote.WeatherApi
import com.shakuntala.rayamajhi.ex1.model.Weather

class WeatherRepository(
    private val weatherApi: WeatherApi,
    private val weatherDao: WeatherDao
) {
    companion object {
        private const val API_KEY = "557406db5401ff53310a52cbae36b214"
    }

    // Fetch weather data from the remote API
    suspend fun getWeather(city: String): Weather {
        // Try fetching weather data from the remote API
        val weatherResponse = weatherApi.getWeather(city, API_KEY)

        // Save the fetched data into the local database
        val weather = Weather(
            city = city,
            temperature = weatherResponse.main.temp,
            description = weatherResponse.weather.firstOrNull()?.description.orEmpty()
        )
        weatherDao.insertWeather(weather)

        return weather
    }

    // Fetch all saved weather data from the local database
    suspend fun getSavedWeather(): List<Weather> {
        return weatherDao.getAllWeather()
    }
    suspend fun getAllWeather(): List<Weather> {
        return weatherDao.getAllWeather()  // Calling the method from the DAO
    }


}
