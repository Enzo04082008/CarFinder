package com.example.carfinder.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carfinder.data.repository.CarRepository

/**
 * Tela de Detalhes do Veículo - Desenvolvedor 3 / Responsável por Detalhes e Favoritos
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    carId: String
) {
    val repository = remember { CarRepository() }
    val car = remember(carId) { repository.getCarById(carId) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(car?.name ?: "Detalhes do Veículo") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            if (car != null) {
                Text(
                    text = "${car.brand} ${car.name}",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ano: ${car.year} | Modelo: ${car.model}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Preço: R$ %.2f".format(car.price),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                Text(text = "Veículo não encontrado.")
            }
        }
    }
}
