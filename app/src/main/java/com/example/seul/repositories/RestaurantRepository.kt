package com.example.seul.repositories

import com.example.seul.models.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurants(): List<Restaurant>
    suspend fun getRestaurant(id: String): Restaurant
    suspend fun postRestaurant(restaurant: Restaurant)
    suspend fun deleteRestaurant(id: String)
}
