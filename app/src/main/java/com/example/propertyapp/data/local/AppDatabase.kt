package com.example.propertyapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.propertyapp.data.model.HouseEntity

/**
 * Room database class that holds the local data for the House API.
 */
@Database(
    entities = [HouseEntity::class], version = 2, exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Returns an instance of [DaoHouseLocal] to interact with the local data.
     */
    abstract fun daoHouseLocal(): DaoHouseLocal
}