package com.example.seul.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seul.ResponseData
import com.example.seul.models.Restaurant
import com.example.seul.repositories.RestaurantRepositoryImpl
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class CreateRestaurantViewModel @Inject constructor(
    private val restaurantRepository: RestaurantRepositoryImpl
) : ViewModel(){

    private val _restaurantCreated = MutableLiveData<Boolean>()
    val restaurantCreated : LiveData<Boolean>
        get() = _restaurantCreated

    fun createRestaurant(restaurant: Restaurant) = viewModelScope.launch {
        _restaurantCreated.value = restaurantRepository.postRestaurant(restaurant)
    }

}
