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

class MainViewModel @Inject constructor(
    private val restaurantRepository: RestaurantRepositoryImpl
) : ViewModel(){

    private val _restaurants = MutableLiveData<ResponseData<List<Restaurant>>>()
    val restaurants : LiveData<ResponseData<List<Restaurant>>>
        get() = _restaurants

    fun getRestaurants() = viewModelScope.launch {
        _restaurants.value = ResponseData.Loading()
        val restaurantsList = restaurantRepository.getRestaurants()
        _restaurants.value = restaurantsList
    }

}
