package com.example.carfinder.data.model

/**
 * Modelo de dados representando um veículo no CarFinder.
 */
data class Car(
    val id: String,
    val name: String,
    val brand: String,
    val model: String,
    val year: Int,
    val price: Double,
    val imageUrl: String = "",
    val description: String = "",
    val isFavorite: Boolean = false
)
