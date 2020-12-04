package com.example.whattocook

data class Recipe(
    val name: String,
    val category: String = "Others",
    val totalPrice: Int,
)
