package com.shakuntala.rayamajhi.ex1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather") // This defines the table name as "weather"
data class Weather(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val city: String,
    val temperature: Float,
    val description: String
)
