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

class RestaurantDetailViewModel @Inject constructor(
    private val restaurantRepository: RestaurantRepositoryImpl
) : ViewModel(){

    private val _restaurant = MutableLiveData<ResponseData<Restaurant>>()
    val restaurant : LiveData<ResponseData<Restaurant>>
        get() = _restaurant

    private val _restaurantDeleted = MutableLiveData<Boolean>()
    val restaurantDeleted : LiveData<Boolean>
        get() = _restaurantDeleted

    fun getRestaurant(id: String) = viewModelScope.launch {
        _restaurant.value = ResponseData.Loading()
        _restaurant.value = restaurantRepository.getRestaurant(id)
    }

    fun deleteRestaurant(id: String) = viewModelScope.launch {
        _restaurantDeleted.value = restaurantRepository.deleteRestaurant(id)
    }

}
