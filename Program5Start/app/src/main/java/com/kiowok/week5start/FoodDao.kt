package com.kiowok.week5start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface FoodDao {
    @Insert
    fun insertFood(product: Food)

    @Query("SELECT * FROM foods")
    fun getAllFoods(): LiveData<List<Food>>

    @Query("DELETE FROM foods WHERE foodName = :foodName")
    fun removeFood(foodName: String)
}