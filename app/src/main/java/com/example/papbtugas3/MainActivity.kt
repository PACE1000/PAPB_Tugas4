package com.example.papbtugas3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.papbtugas3.Navigation.SetNavGraph
import com.example.papbtugas3.ui.theme.PAPBTugas3Theme

class MainActivity : ComponentActivity() {
    lateinit var navController : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAPBTugas3Theme {
               navController = rememberNavController()
                SetNavGraph(navController = navController)
            }
        }
    }
}

