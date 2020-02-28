package com.kiowok.week5start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FoodRepository =
        FoodRepository(application)
    val allFoods: LiveData<List<Food>>?

    init {
        allFoods = repository.allFoods
    }

    fun insertFood(food: Food) {
        repository.insertFood(food)
    }
    fun removeFood(food: String){
        repository.removeFood(food)
    }
}