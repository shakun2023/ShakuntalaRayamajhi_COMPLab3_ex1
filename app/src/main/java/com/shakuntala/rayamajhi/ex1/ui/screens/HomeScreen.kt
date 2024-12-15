package com.shakuntala.rayamajhi.ex1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shakuntala.rayamajhi.ex1.ui.navigation.Screen
import com.shakuntala.rayamajhi.ex1.viewmodel.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: WeatherViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    var city by remember { mutableStateOf("") }
    val weather = viewModel.weather.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Weather Tracker") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("Enter city") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    viewModel.fetchWeather(city)
                    navController.navigate(Screen.Details.createRoute(city))
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Get Weather")
            }
        }
    }
}
