package com.kiowok.week5start

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FoodRepository(application: Application) {
    val allFoods: LiveData<List<Food>>?

    private var foodDao: FoodDao?

    init {
        val db: FoodDatabase? =
            FoodDatabase.getDatabase(application)
        foodDao = db?.foodDao()
        allFoods = foodDao?.getAllFoods()
    }

    fun insertFood(newfood: Food) {
        val task = InsertAsyncTask(foodDao)
        task.execute(newfood)
    }
    fun removeFood(currentFood: String) {
        val work = DeleteAsyncTask(foodDao)
        work.execute(currentFood)
    }

    private class InsertAsyncTask constructor(private val asyncTaskDao: FoodDao?) :
        AsyncTask<Food, Void, Void>() {

        override fun doInBackground(vararg params: Food): Void? {
            asyncTaskDao?.insertFood(params[0])
            return null
        }
    }
    private class DeleteAsyncTask constructor(private val mAsyncTaskDao: FoodDao?) :
        AsyncTask<String, Void, Void>() {

        override fun doInBackground(vararg params: String): Void? {

            mAsyncTaskDao?.removeFood(params[0])
            return null
        }
    }

}
