package com.example.propertyapp.network

import com.example.propertyapp.data.model.HouseResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * This interface is used to make API calls to a backend server
 */
interface HouseAPIService {
    @GET("house")
    suspend fun getAllHouses(): Response<HouseResponse>
}