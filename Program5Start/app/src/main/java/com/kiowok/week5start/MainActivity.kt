package com.kiowok.week5start

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiowok.week13room.R

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private var adapter: FoodListAdapter? = null
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.allFoods?.observe(this, Observer { foods ->
            foods?.let  {
                adapter?.setFoodList(it)
            }
        })

        adapter = FoodListAdapter(R.layout.food_row)
        food_recycler.layoutManager = LinearLayoutManager(this)
        food_recycler.adapter = adapter
        val name =  value.text.toString()
        add.setOnClickListener { view ->
            viewModel.insertFood(Food(value.text.toString()))
        }
        delete.setOnClickListener{view->
            viewModel.removeFood(value.text.toString())

            }
    }
}
