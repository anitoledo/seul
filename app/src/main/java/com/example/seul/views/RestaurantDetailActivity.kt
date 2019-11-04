package com.example.seul.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.seul.R
import com.example.seul.ResponseData
import com.example.seul.di.ViewModelFactory
import com.example.seul.viewmodels.RestaurantDetailViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_restaurant_detail.*
import timber.log.Timber
import javax.inject.Inject

private const val ERROR_VIEW = 0
private const val DETAIL_VIEW = 1

class RestaurantDetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<RestaurantDetailViewModel>{ viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        val restaurantId = intent.extras?.get("restaurantId").toString()

        viewModel.getRestaurant(restaurantId)

        viewModel.restaurant.observe(this, Observer {
            when (it) {
                is ResponseData.Success -> {
                    restaurantRefresh.isRefreshing = false
                    name.text = it.data.name
                    category.text = it.data.category
                    description.text = it.data.description
                    restaurantView.displayedChild = DETAIL_VIEW
                }
                is ResponseData.Error -> {
                    restaurantView.displayedChild = ERROR_VIEW
                }
                is ResponseData.Loading -> restaurantRefresh.isRefreshing = true
            }
        })

        viewModel.restaurantDeleted.observe(this, Observer {
            if(it){
                Toast.makeText(this, getString(R.string.restaurant_deleted), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_LONG).show()
            }
            finish()
        })

        restaurantRefresh.setOnRefreshListener {
            viewModel.getRestaurant(restaurantId)
        }

        deleteRestaurant.setOnClickListener {
            viewModel.deleteRestaurant(restaurantId)
        }
    }
}
