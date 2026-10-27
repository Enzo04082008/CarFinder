package com.example.carfinder

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {

    // 1. Lista fictícia de carros para teste de busca
    private val allCars = listOf(
        Car(1, "Civic", "Honda", 2022, 145000.0),
        Car(2, "Corolla", "Toyota", 2021, 130000.0),
        Car(3, "Golf GTI", "Volkswagen", 2023, 210000.0),
        Car(4, "Focus", "Ford", 2020, 75000.0),
        Car(5, "Sentra", "Nissan", 2021, 115000.0),
        Car(6, "Camry", "Toyota", 2023, 310000.0),
        Car(7, "Onix", "Chevrolet", 2023, 85000.0),
        Car(8, "HB20", "Hyundai", 2022, 78000.0),
        Car(9, "Polo", "Volkswagen", 2023, 92000.0),
        Car(10, "Compass", "Jeep", 2023, 180000.0),
        Car(11, "Renegade", "Jeep", 2022, 125000.0),
        Car(12, "Tracker", "Chevrolet", 2023, 135000.0),
        Car(13, "Creta", "Hyundai", 2023, 140000.0),
        Car(14, "Mustang GT", "Ford", 2022, 510000.0),
        Car(15, "BMW 320i", "BMW", 2023, 320000.0),
        Car(16, "Audi A4", "Audi", 2022, 290000.0),
        Car(17, "C-Class C300", "Mercedes-Benz", 2023, 380000.0),
        Car(18, "Model 3", "Tesla", 2023, 280000.0),
        Car(19, "Kardian", "Renault", 2024, 112000.0),
        Car(20, "Fastback", "Fiat", 2023, 128000.0),
        Car(21, "Toro", "Fiat", 2022, 145000.0)
    )

    // Guarda o texto que o usuário digita na barra de pesquisa
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    // Guarda a lista de carros filtrada que é exibida
    private val _filteredCars = MutableStateFlow(allCars)
    val filteredCars: StateFlow<List<Car>> = _filteredCars.asStateFlow()

    // Função chamada quando o usuário digita ou apaga uma letra na busca
    fun onSearchQueryChange(newQuery: String) {
        _searchQuery.value = newQuery

        _filteredCars.value = if (newQuery.isBlank()) {
            allCars
        } else {
            allCars.filter { car ->
                car.model.contains(newQuery, ignoreCase = true) ||
                car.brand.contains(newQuery, ignoreCase = true)
            }
        }
    }
}