package com.example.seul.repositories

import com.example.seul.ResponseData
import com.example.seul.data.remote.RestaurantsApi
import com.example.seul.models.Restaurant
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val restaurantsApi: RestaurantsApi
) : RestaurantRepository{

    override suspend fun getRestaurants(): ResponseData<List<Restaurant>> {
        return try {
            ResponseData.Success(restaurantsApi.getRestaurants())
        } catch (e: Exception){
            ResponseData.Error()
        }
    }

    override suspend fun getRestaurant(id: String): ResponseData<Restaurant> {
        return try {
            ResponseData.Success(restaurantsApi.getRestaurant(id))
        } catch (e: Exception){
            ResponseData.Error()
        }
    }

    override suspend fun postRestaurant(restaurant: Restaurant): Boolean {
        return try {
            restaurantsApi.postRestaurant(restaurant)
            true
        } catch (e: Exception){
            false
        }
    }

    override suspend fun deleteRestaurant(id: String): Boolean {
        return try {
            restaurantsApi.deleteRestaurant(id)
            true
        } catch (e: Exception){
            false
        }
    }

}
