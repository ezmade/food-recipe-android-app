package com.example.whattocook.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipesListResponse(
    @SerialName("recipes")
    val recipes: List<RecipeEntity>? = null
)