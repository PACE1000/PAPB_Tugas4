package com.example.papbtugas3.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.papbtugas3.Screen.HomeScreen
import com.example.papbtugas3.Screen.TemperatureScreen
import com.example.papbtugas3.Screen.VolumeScreen

@Composable 
fun SetNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
        composable(route ="Home_Screen"){
            HomeScreen(navController = navController)
        }

        composable(route = "Temperature_Screen"){
            TemperatureScreen(navController = navController)
        }

        composable(route = "Volume_Screen"){
            VolumeScreen(navController = navController)
        }
    }
}