package com.example.whattocook.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

val RECIPES_API: RecipesApi = Retrofit.Builder()
        .baseUrl("https://api.spoonacular.com/")
        .addConverterFactory(Json(builderAction = {
            ignoreUnknownKeys = true
        }).asConverterFactory("application/json".toMediaType()))
        .build()
        .create()


