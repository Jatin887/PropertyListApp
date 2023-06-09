package com.example.propertyapp.ui.screens.detailedHouse

import com.example.propertyapp.domain.model.House

interface DetailedHouseContract {
    sealed class Event {
        class GetHouse(val houseId: Int) : Event()
        object OnErrorShown : Event()
    }

    data class State(
        val house : House,
        val isLoading: Boolean = false,
        val error: String?
    )
}