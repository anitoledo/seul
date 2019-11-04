package com.example.seul.views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.seul.R
import com.example.seul.ResponseData
import com.example.seul.adapters.RestaurantsAdapter
import com.example.seul.di.ViewModelFactory
import com.example.seul.extensions.hide
import com.example.seul.extensions.show
import com.example.seul.models.Restaurant
import com.example.seul.viewmodels.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<MainViewModel>{ viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restaurantsAdapter = RestaurantsAdapter{
            goToRestaurantDetail(it)
        }

        restaurantsRecycler.adapter = restaurantsAdapter

        viewModel.restaurants.observe(this, Observer {
            when (it) {
                is ResponseData.Success -> {
                    errorMessage.hide()
                    restaurantsAdapter.setRestaurants(it.data)
                }
                is ResponseData.Error -> {
                    errorMessage.show()
                }
                is ResponseData.Loading -> restaurantsRefresh.isRefreshing = true
            }
            restaurantsRefresh.isRefreshing = false
        })

        addRestaurant.setOnClickListener {
            addRestaurant()
        }

        restaurantsRefresh.setOnRefreshListener {
            viewModel.getRestaurants()
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.getRestaurants()
    }

    private fun goToRestaurantDetail(restaurant: Restaurant){
        val intent = Intent(this, RestaurantDetailActivity::class.java)
        intent.putExtra("restaurantId", restaurant.id)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu?.findItem(R.id.search)
        searchItem?.expandActionView()
        return super.onCreateOptionsMenu(menu)
    }

    private fun addRestaurant() {
        val intent = Intent(this, CreateRestaurantActivity::class.java)
        startActivity(intent)
    }
}
