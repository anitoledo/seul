package com.example.seul.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.seul.R
import com.example.seul.models.Restaurant
import java.lang.Float.parseFloat

class RestaurantsAdapter : RecyclerView.Adapter<RestaurantsAdapter.RestaurantViewHolder>(){

    private var restaurants: List<Restaurant>  = listOf()

    fun setRestaurants(restaurants: List<Restaurant>){
        this.restaurants = restaurants
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false))
    }

    override fun getItemCount(): Int = restaurants.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = restaurants[position]
        holder.bind(currentItem)
    }

    class RestaurantViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        private val restaurantName: TextView = view.findViewById(R.id.restaurantName)
        private val restaurantCategory: TextView = view.findViewById(R.id.restaurantCategory)
        private val restaurantRating: RatingBar = view.findViewById(R.id.restaurantRating)

        fun bind(restaurant: Restaurant){
            restaurantName.text = restaurant.name
            restaurantCategory.text = restaurant.category
            restaurantRating.rating = parseFloat(restaurant.score)
        }
    }

}
