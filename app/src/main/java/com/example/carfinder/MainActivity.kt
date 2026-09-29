package com.example.carfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.carfinder.ui.screens.home.HomeScreen
import com.example.carfinder.ui.theme.CarFinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarFinderTheme {
                HomeScreen()
            }
        }
    }
}
