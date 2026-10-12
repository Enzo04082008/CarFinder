package com.example.carfinder

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {

    // 1. Lista fictícia de carros para teste de busca
    private val allCars = listOf(
        Car(1, "Civic", "Honda", 2022, 25000.0),
        Car(2, "Corolla", "Toyota", 2021, 22000.0),
        Car(3, "Golf", "Volkswagen", 2023, 30000.0),
        Car(4, "Focus", "Ford", 2022, 28000.0),
        Car(5, "Sentra", "Nissan", 2021, 21000.0),
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