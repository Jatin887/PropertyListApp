package com.example.propertyapp.data.remote

import com.example.propertyapp.data.model.toHouse
import com.example.propertyapp.domain.model.House
import com.example.propertyapp.network.HouseAPIService
import com.example.propertyapp.network.NetworkResult
import javax.inject.Inject

/**
 * Fetches data from remote source, calling the generic [BaseAPIResponse.safeApiCall] function.
 */
class HouseRemoteDataSource @Inject constructor(
    private val houseApiService: HouseAPIService
) : BaseAPIResponse() {
    suspend fun fetchHouses(): NetworkResult<List<House>> {
        return safeApiCall(apiCall = { houseApiService.getAllHouses() },
            transform = { housesResponse -> housesResponse.map { it.toHouse() } })
    }
}

