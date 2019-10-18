package com.example.seul.di.modules

import com.example.seul.BuildConfig
import com.example.seul.data.remote.RestaurantsApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BuildConfig.BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideRestaurantsApi(retrofit: Retrofit): RestaurantsApi = retrofit.create(RestaurantsApi::class.java)

}
