package com.example.papbtugas3.Asset

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.papbtugas3.ui.theme.PAPBTugas3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(navController: NavController){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Tugas 4 PAPB",color = Color.Black)
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigate(route = "Home_Screen")}) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        }, actions = {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        },
        scrollBehavior = scrollBehavior
    )
}

@Preview
@Composable
fun PreviewTopBar(){
    PAPBTugas3Theme {
        Topbar(navController = rememberNavController())
    }
}