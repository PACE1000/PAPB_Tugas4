package com.example.papbtugas3.Asset

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coronavirus
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.papbtugas3.ui.theme.PAPBTugas3Theme

@Composable
fun BoxPilihan(
     title:String,
     Icon:ImageVector,
     modifier : Modifier
) {
    Box(
        modifier = modifier
            .width(300.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = Icon, contentDescription = "Logo Pelengkap",
                modifier = Modifier.size(30.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icon, contentDescription = "Logo Pelengkap",
                modifier = Modifier.size(30.dp))
        }
    }
}

@Preview
@Composable
fun PreviewBoxPilihan(){
    PAPBTugas3Theme {
        BoxPilihan(title = "Temperature", Icon = Icons.Default.Coronavirus, modifier = Modifier)
    }
}