package com.shakuntala.rayamajhi.ex1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shakuntala.rayamajhi.ex1.data.WeatherRepository
import com.shakuntala.rayamajhi.ex1.model.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weather = MutableStateFlow<Weather?>(null)
    val weather: StateFlow<Weather?> = _weather

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            try {
                val weatherData = repository.getWeather(city)
                _weather.value = weatherData
            } catch (e: Exception) {
                // Handle the error (e.g., show a message in the UI)
                _weather.value = null
            }
        }
    }
}
