package com.shakuntala.rayamajhi.ex1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shakuntala.rayamajhi.ex1.ui.screens.DetailsScreen
import com.shakuntala.rayamajhi.ex1.ui.screens.HomeScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details/{city}") {
        fun createRoute(city: String) = "details/$city"
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Details.route) { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city")
            city?.let {
                DetailsScreen(navController = navController, city = it)
            }
        }
    }
}
