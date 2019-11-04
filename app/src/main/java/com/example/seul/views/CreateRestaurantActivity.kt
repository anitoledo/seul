package com.example.seul.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.seul.R
import com.example.seul.di.ViewModelFactory
import com.example.seul.models.Location
import com.example.seul.models.Restaurant
import com.example.seul.viewmodels.CreateRestaurantViewModel
import com.example.seul.viewmodels.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_create_restaurant.*
import java.lang.Double.parseDouble
import javax.inject.Inject

class CreateRestaurantActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<CreateRestaurantViewModel>{ viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_restaurant)

        viewModel.restaurantCreated.observe(this, Observer {
            if(it){
                Toast.makeText(this, getString(R.string.restaurant_created), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_LONG).show()
            }
            finish()
        })

        createRestaurant.setOnClickListener {
            createRestaurant()
        }
    }

    private fun createRestaurant(){
        viewModel.createRestaurant(
            Restaurant(
                null,
                restaurantName.text.toString(),
                restaurantDescription.text.toString(),
                Location(
                    parseDouble(restaurantLatitude.text.toString()),
                    parseDouble(restaurantLongitude.text.toString())
                ),
                0f,
                restaurantCategory.text.toString(),
                null
            )
        )
    }
}
