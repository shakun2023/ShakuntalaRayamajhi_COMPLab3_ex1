package com.shakuntala.rayamajhi.ex1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shakuntala.rayamajhi.ex1.model.Weather

@Database(entities = [Weather::class], version = 1,exportSchema = false )
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
