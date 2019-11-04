package com.example.seul.repositories

import com.example.seul.ResponseData
import com.example.seul.models.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurants(): ResponseData<List<Restaurant>>
    suspend fun getRestaurant(id: String): ResponseData<Restaurant>
    suspend fun postRestaurant(restaurant: Restaurant): Boolean
    suspend fun deleteRestaurant(id: String): Boolean
}
