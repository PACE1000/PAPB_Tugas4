package com.example.papbtugas3.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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


@Composable
fun VolumeScreen(navController: NavController){

    var Tinggi by remember {
        mutableStateOf("")
    }

    var Lebar by remember {
        mutableStateOf("")
    }

    var Panjang by remember {
        mutableStateOf("")
    }

    var Hasil by remember {
        mutableStateOf(BigDecimal.ZERO)
    }
    var hasil = Hasil.toString()

    Scaffold(
        topBar = { Topbar(navController = navController)},
        content = { padding ->
            Column(
                modifier = Modifier.padding(padding)
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Yellow),
                    contentAlignment = Alignment.Center){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Tinggi",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        TextField(value =Tinggi ,
                            onValueChange ={Tinggi = it},
                            placeholder = { Text(text = "Masukkan Tinggi") },
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White))

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Panjang",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        TextField(value =Panjang ,
                            onValueChange ={Panjang = it},
                            placeholder = { Text(text = "Masukkan Panjang") },
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White))

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Lebar",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        TextField(value =Lebar ,
                            onValueChange ={Lebar = it},
                            placeholder = { Text(text = "Masukkan Lebar") },
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White))

                        Spacer(modifier = Modifier.height(15.dp))
                        Button(onClick = {
                            Hasil = RumusVolume(
                                Panjang = Panjang,
                                Lebar = Lebar,
                                Tinggi = Tinggi)
                        }) {
                            Text(text = "Hitung", color = Color.White)
                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Hasil",
                            color = Color.Black,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        TextField(value = hasil,
                            onValueChange ={ hasil = it},
                            placeholder = { Text(text = "Hasil") },
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White))
                    }
                }
            }
        }
    )
}

fun RumusVolume(
    Panjang:String,
    Lebar:String,
    Tinggi:String
):BigDecimal{
    val P = Panjang.toBigDecimalOrNull()?: BigDecimal.ZERO
    val T = Tinggi.toBigDecimalOrNull()?: BigDecimal.ZERO
    val L  = Lebar.toBigDecimalOrNull()?: BigDecimal.ZERO

    var volume = P * L * T
    return volume
}

@Preview
@Composable
fun PreviewVolumeScreen(){
    PAPBTugas3Theme {
        VolumeScreen(navController = rememberNavController())
    }
}