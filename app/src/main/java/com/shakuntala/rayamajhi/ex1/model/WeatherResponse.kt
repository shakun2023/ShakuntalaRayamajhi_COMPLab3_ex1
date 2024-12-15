package com.shakuntala.rayamajhi.ex1.model

data class WeatherResponse(
    val location: String,
    val temperature: Float,
    val description: String,
    val humidity: Int,
    val main: MainWeather,
    val weather: List<WeatherDescription>,
    val name: String
)

data class MainWeather(
    val temp: Float,
    val humidity: Int
)

data class WeatherDescription(
    val description: String
)