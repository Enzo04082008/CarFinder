package com.example.carfinder.data.repository

import com.example.carfinder.data.model.Car

/**
 * Repositório responsável pela gestão dos dados dos veículos.
 * Pode ser estendido para buscar de uma API remota ou banco de dados local.
 */
class CarRepository {

    fun getCars(): List<Car> {
        return listOf(
            Car("1", "Civic", "Honda", "EXL", 2022, 125000.0),
            Car("2", "Corolla", "Toyota", "XEI", 2023, 138000.0),
            Car("3", "Onix", "Chevrolet", "Premier", 2021, 78000.0)
        )
    }

    fun getCarById(id: String): Car? {
        return getCars().find { it.id == id }
    }
}
