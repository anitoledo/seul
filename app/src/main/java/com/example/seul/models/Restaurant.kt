package com.example.seul.models

data class Restaurant(
    val id: String,
    val name: String,
    val description: String,
    val location: Location,
    val score: String,
    val category: String,
    val menu: List<MenuItem>?
)
