package com.example.whattocook.di

import com.example.whattocook.data.entity.RecipesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesApi {

    @GET("recipes/random")
    suspend fun getRecipesList(
            @Query("number") number: Int,
            @Query("apiKey") apiKey: String = "7af940a49d524d50ad66f72a4dac4256",
            @Query("tags") tags: String,
    ): RecipesListResponse
}