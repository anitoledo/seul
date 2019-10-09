package com.example.seul.repositories

import com.example.seul.data.remote.restaurantsApi
import com.example.seul.models.Restaurant

class RestaurantRepositoryImpl : RestaurantRepository{
    override suspend fun getRestaurants(): List<Restaurant> {
        return restaurantsApi.getRestaurants()
    }

    override suspend fun getRestaurant(id: String): Restaurant {
        return restaurantsApi.getRestaurant(id)
    }

    override suspend fun postRestaurant(restaurant: Restaurant) {
        return restaurantsApi.postRestaurant(restaurant)
    }

    override suspend fun deleteRestaurant(id: String) {
        return restaurantsApi.deleteRestaurant(id)
    }

}
