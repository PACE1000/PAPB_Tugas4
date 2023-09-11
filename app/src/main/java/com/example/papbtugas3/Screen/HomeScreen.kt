package com.example.papbtugas3.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CandlestickChart
import androidx.compose.material.icons.filled.Coronavirus
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.papbtugas3.Asset.BoxPilihan
import com.example.papbtugas3.ui.theme.PAPBTugas3Theme

@Composable
fun HomeScreen(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue),
        contentAlignment = Alignment.Center){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Arya Bramaputra \n " +
                        "21060120120033 \n " +
                        "Pengembangan Aplikasi Perangkat Bergerak",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(10.dp))

            BoxPilihan(
                title = "Temperature",
                Icon = Icons.Default.Coronavirus,
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .clickable { navController.navigate("Temperature_Screen") })

            Spacer(modifier = Modifier.height(10.dp))

            BoxPilihan(
                title = "Volume",
                Icon = Icons.Default.CandlestickChart,
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .clickable { navController.navigate("Volume_Screen") })
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen(){
    PAPBTugas3Theme {
        HomeScreen(navController = rememberNavController())
    }
}