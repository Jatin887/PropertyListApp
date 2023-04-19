package com.example.propertyapp.ui.screens.home

import com.example.propertyapp.domain.model.House

interface ListHousesActions {
    fun onHouseClicked(house: House)
}