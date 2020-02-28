package com.kiowok.week5start

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Food::class)], version = 1)

abstract class FoodDatabase: RoomDatabase() {

    abstract fun foodDao(): FoodDao

    companion object {

        private var INSTANCE: FoodDatabase? = null

        internal fun getDatabase(context: Context): FoodDatabase? {
            if (INSTANCE == null) {
                synchronized(FoodDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder<FoodDatabase>(
                                context.applicationContext,
                                FoodDatabase::class.java,
                                "foods.db").build()
                    }
                }
            }
            return INSTANCE
        }
    }
}