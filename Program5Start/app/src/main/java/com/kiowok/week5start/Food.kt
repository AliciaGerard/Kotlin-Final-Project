package com.kiowok.week5start

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
class Food {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int = 0


    @ColumnInfo(name = "foodName")
    var foodName: String? = null

    constructor() {
        this.foodName = "DEFAULT"
    }

    constructor(foodName: String?) {
        this.foodName = foodName
    }

    constructor(id: Int, foodName: String?) {
        this.id = id
        this.foodName = foodName
    }
}