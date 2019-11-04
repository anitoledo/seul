package com.example.seul.data.remote

import com.example.seul.models.Restaurant
import retrofit2.http.*

interface RestaurantsApi {
    @GET("restaurant")
    suspend fun getRestaurants(): List<Restaurant>

    @POST("restaurant")
    suspend fun postRestaurant(@Body restaurant: Restaurant)

    @GET("restaurant/{id}")
    suspend fun getRestaurant(@Path("id") id: String): Restaurant

    @DELETE("restaurant/{id}")
    suspend fun deleteRestaurant(@Path("id") id: String)
}
