package com.example.seul.data.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val BASE_URL = ""

private val gson = GsonBuilder().create()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl(BASE_URL)
    .build()

val restaurantsApi : RestaurantsApi by lazy {
    retrofit.create(RestaurantsApi::class.java)
}
