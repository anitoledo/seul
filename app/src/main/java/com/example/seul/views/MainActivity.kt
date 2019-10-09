package com.example.seul.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.seul.R
import com.example.seul.ResponseData
import com.example.seul.adapters.RestaurantsAdapter
import com.example.seul.models.Location
import com.example.seul.models.Restaurant
import com.example.seul.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val restaurants = listOf(
        Restaurant(
            "123",
            "McDonalds",
            "Cheap fast food",
            Location(123.0, 123.0),
            "5",
            "Fast Food",
            null
        ),
        Restaurant(
            "123",
            "Burger King",
            "Cheap fast food",
            Location(123.0, 123.0),
            "3.2",
            "Fast Food",
            null
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restaurantsAdapter = RestaurantsAdapter()
//        restaurantsAdapter.setRestaurants(restaurants)

        restaurantsRecycler.adapter = restaurantsAdapter

        val viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        viewModel.restaurants.observe(this, Observer {
            when(it){
                is ResponseData.Success -> restaurantsAdapter.setRestaurants(restaurants)
                is ResponseData.Error -> {
                    // Handle Error
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem =  menu?.findItem(R.id.search)
        searchItem?.expandActionView()
        return super.onCreateOptionsMenu(menu)
    }
}
