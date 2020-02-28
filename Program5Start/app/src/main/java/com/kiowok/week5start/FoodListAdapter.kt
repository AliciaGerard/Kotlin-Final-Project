package com.kiowok.week5start

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kiowok.week13room.R

class FoodListAdapter (private val foodItemLayout: Int) :
    RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    private var foodList: List<Food>? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val item = holder.item
        foodList.let {
            item.text = it!![listPosition].foodName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            foodItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setFoodList(foods: List<Food>) {
        foodList = foods
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {

        return if (foodList == null) 0 else foodList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView = itemView.findViewById(R.id.textFoodName)
    }
}