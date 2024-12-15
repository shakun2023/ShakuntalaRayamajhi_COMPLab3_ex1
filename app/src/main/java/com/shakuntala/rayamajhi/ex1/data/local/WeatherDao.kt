package com.shakuntala.rayamajhi.ex1.data.local

import androidx.room.Dao
import androidx.room.*
import androidx.room.Insert
import androidx.room.Query
import com.shakuntala.rayamajhi.ex1.model.Weather

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: Weather)

    @Query("SELECT * FROM weather WHERE id = :id")
    suspend fun getWeather(id: Int): Weather

    @Query("SELECT * FROM weather")
    suspend fun getAllWeather(): List<Weather>

    @Delete
    suspend fun deleteWeather(weather: Weather)

    @Update
    suspend fun updateWeather(weather: Weather)
}
