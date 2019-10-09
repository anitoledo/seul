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

class MainViewModel : ViewModel(){

    private val restaurantRepository = RestaurantRepositoryImpl()

    private val _restaurants = MutableLiveData<ResponseData<List<Restaurant>>>()
    val restaurants : LiveData<ResponseData<List<Restaurant>>>
        get() = _restaurants

    init {
        getRestaurants()
    }

    private fun getRestaurants() = viewModelScope.launch {
        try {
            val restaurantsList = restaurantRepository.getRestaurants()
            _restaurants.postValue(ResponseData.Success(restaurantsList))
        } catch (exception: IOException){
            _restaurants.postValue(ResponseData.Error())
        }
    }

}
