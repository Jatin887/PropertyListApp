package com.example.propertyapp.domain.usecases.house

import com.example.propertyapp.data.repository.HouseRepository
import javax.inject.Inject

class GetAllHousesUseCase @Inject constructor(
    private val houseRepository: HouseRepository
) {
    operator fun invoke() = houseRepository.getAllHouses()
}