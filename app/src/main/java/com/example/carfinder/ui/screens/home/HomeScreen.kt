package com.example.carfinder.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.carfinder.data.repository.CarRepository
import com.example.carfinder.ui.components.CarCard

/**
 * Tela Inicial (Home) - Desenvolvedor 1 / Responsável por Lista e Destaques
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onCarClick: (String) -> Unit = {}
) {
    val repository = remember { CarRepository() }
    val cars = remember { repository.getCars() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("CarFinder - Destaques") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn {
                items(cars) { car ->
                    CarCard(
                        car = car,
                        onClick = { onCarClick(car.id) }
                    )
                }
            }
        }
    }
}
