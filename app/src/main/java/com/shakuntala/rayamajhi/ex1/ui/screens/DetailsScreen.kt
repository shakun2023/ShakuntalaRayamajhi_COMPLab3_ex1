package com.shakuntala.rayamajhi.ex1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shakuntala.rayamajhi.ex1.viewmodel.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, city: String, viewModel: WeatherViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val weather = viewModel.weather.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Weather Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            weather.value?.let { weatherData ->
                Text("City: $city")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Temperature: ${weatherData.temperature}")
                Text("Description: ${weatherData.description}")
            } ?: Text("Loading...")
        }
    }
}
