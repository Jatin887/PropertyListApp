package com.example.propertyapp.ui.screens.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.propertyapp.R
import com.example.propertyapp.common.Constants
import com.example.propertyapp.databinding.ItemHouseBinding
import com.example.propertyapp.domain.model.House
import com.example.propertyapp.utils.Utils

class HouseAdapter(
    private val actions: ListHousesActions
) : ListAdapter<House, HouseAdapter.HouseViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseViewHolder {
        return HouseViewHolder(
            actions, LayoutInflater.from(parent.context).inflate(
                R.layout.item_house, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HouseViewHolder, position: Int) = with(holder) {
        val house = getItem(position)
        bind(house)
    }

    class HouseViewHolder(private val actions: ListHousesActions, view: View) :
        RecyclerView.ViewHolder(view) {
        private val binding = ItemHouseBinding.bind(view)
        val context: Context = view.context
        fun bind(
            house: House
        ) = with(binding) {
            Utils.getHouseWithDistance(house, context)
            val imageUrl = Constants.IMAGE_RELATIVE_PATH + house.image
            val housePriceTxt = Constants.DOLLAR_CHARACTER + house.price.toString()
            housePrice.text = housePriceTxt
            houseZipCode.text = house.zipCode
            houseBathroomNumber.text = house.bathrooms.toString()
            houseBedroomNumber.text = house.bedrooms.toString()
            houseMetersNumber.text = house.size.toString()
            houseImageView.load(imageUrl)
            kmNumberTextView.text = house.distance.toString()
            cardViewHouse.setOnClickListener {
                actions.onHouseClicked(house)
            }
        }
    }

    fun filterList(query: String?) {
        val filteredList: MutableList<House> = mutableListOf()
        for (house in currentList) {
            if (house.zipCode.contains(query.toString(), true) || house.city.contains(
                    query.toString(), true
                )
            ) {
                filteredList.add(house)
            }
        }
        submitList(filteredList)
    }

    class DiffCallback : DiffUtil.ItemCallback<House>() {
        override fun areItemsTheSame(oldItem: House, newItem: House): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: House, newItem: House): Boolean {
            return oldItem == newItem
        }
    }
}