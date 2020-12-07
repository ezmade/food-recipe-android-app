package com.example.whattocook

import java.io.Serializable

data class Recipe (
    val name: String,
    val category: String = "Others",
    val totalPrice: Int,
): Serializable
