package com.example.seul.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.seul.R
import com.example.seul.ResponseData
import com.example.seul.adapters.RestaurantsAdapter
import com.example.seul.di.ViewModelFactory
import com.example.seul.models.Location
import com.example.seul.models.Restaurant
import com.example.seul.viewmodels.MainViewModel
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restaurantsAdapter = RestaurantsAdapter()

        restaurantsRecycler.adapter = restaurantsAdapter

        val viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.restaurants.observe(this, Observer {
            when(it){
                is ResponseData.Success -> restaurantsAdapter.setRestaurants(it.data)
                is ResponseData.Error -> {
                    // Handle Error
                }
            }
        })

        addRestaurant.setOnClickListener {
            addRestaurant()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem =  menu?.findItem(R.id.search)
        searchItem?.expandActionView()
        return super.onCreateOptionsMenu(menu)
    }

    private fun addRestaurant(){
        val intent = Intent(this, CreateRestaurantActivity::class.java)
        startActivity(intent)
    }
}
