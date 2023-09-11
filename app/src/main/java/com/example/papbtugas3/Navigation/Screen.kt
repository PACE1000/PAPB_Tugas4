package com.example.papbtugas3.Navigation

sealed class Screen(val route:String){
    object HomeScreen:Screen(route = "Home_Screen")
    object VolumeScreen:Screen(route = "Volume_Screen")
    object Temperature:Screen(route = "Temperature_String")
}
