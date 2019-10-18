package com.example.seul.repositories

import com.example.seul.data.remote.restaurantsApi
import com.example.seul.models.Location
import com.example.seul.models.Restaurant

class RestaurantRepositoryImpl() : RestaurantRepository{
    override suspend fun getRestaurants(): List<Restaurant> {
        return listOf(
            Restaurant(
                "123",
                "McDonalds",
                "Cheap fast food",
                Location(123.0, 123.0),
                "5",
                "Fast Food",
                null
            ),
            Restaurant(
                "123",
                "Burger King",
                "Cheap fast food",
                Location(123.0, 123.0),
                "3.2",
                "Fast Food",
                null
            )
        )
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
