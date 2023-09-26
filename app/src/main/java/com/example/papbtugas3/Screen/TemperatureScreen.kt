package com.example.papbtugas3.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.papbtugas3.Asset.Topbar
import com.example.papbtugas3.ui.theme.PAPBTugas3Theme
import java.math.BigDecimal
import java.math.RoundingMode


@Composable
fun TemperatureScreen(navController: NavController){
    var Suhu by remember {
        mutableStateOf("")
    }

    var Hasil by remember {
        mutableStateOf(BigDecimal.ZERO)
    }

    var hasil = Hasil.toString()
    Scaffold(
        topBar = { Topbar()},
        content = {
            padding ->
            Column(
                modifier = Modifier.padding(padding)
            ) {
                Box(modifier = Modifier
                    .background(Color.Red)
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Masukkan Suhu",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White)
                        TextField(
                            value = Suhu,
                            onValueChange = { Suhu = it },
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White),
                            placeholder = { Text(text = "Masukkan Suhu")})
                        Spacer(modifier = Modifier.height(10.dp))
                        Icon(
                            imageVector = Icons.Default.ArrowDownward,
                            contentDescription = "Konversi Suhu",
                            tint = Color.White,
                            modifier =Modifier.size(20.dp))

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Hasil",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White)
                        TextField(
                            value = hasil,
                            onValueChange = { hasil = it },
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White),
                            placeholder = { Text(text = "Masukkan Suhu")})
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Button(onClick = {
                                Hasil = RumusSuhu(Suhu = Suhu, Kode ="F")
                                Hasil.setScale(2,RoundingMode.CEILING)
                            }) {
                                Text(text = "F")
                            }
                            Spacer(modifier = Modifier.width(10.dp))

                            Button(onClick = {
                                Hasil = RumusSuhu(Suhu = Suhu, Kode ="R")
                                Hasil.setScale(2,RoundingMode.CEILING)
                            }) {
                                Text(text = "R")
                            }
                            Spacer(modifier = Modifier.width(10.dp))

                            Button(onClick = {
                                Hasil = RumusSuhu(Suhu = Suhu, Kode = "K")
                                Hasil.setScale(2,RoundingMode.CEILING)
                            }) {
                                Text(text = "K")
                            }
                        }
                    }
                }
            }
        }
    )
}

fun RumusSuhu(
    Suhu:String,
    Kode:String
):BigDecimal{
    val suhu = Suhu.toBigDecimalOrNull()?: BigDecimal.ZERO
    val konversi = when (Kode){
        "F" -> suhu*BigDecimal(1.8)+BigDecimal(32)
        "R" -> suhu* BigDecimal(0.8)
        else -> suhu + BigDecimal(272)
    }
    return konversi
}

@Preview
@Composable
fun PreviewTemperatureScreen(){
    PAPBTugas3Theme {
        TemperatureScreen(navController = rememberNavController())
    }
}