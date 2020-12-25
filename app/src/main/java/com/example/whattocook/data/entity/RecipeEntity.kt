package com.example.whattocook.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeEntity(
    @SerialName("aggregateLikes")
    val aggregateLikes: Int? = null,
    @SerialName("analyzedInstructions")
    val analyzedInstructions: List<AnalyzedInstruction>? = null,
    @SerialName("cheap")
    val cheap: Boolean? = null,
    @SerialName("creditsText")
    val creditsText: String? = null,
    @SerialName("cuisines")
    val cuisines: List<String>? = null,
    @SerialName("dairyFree")
    val dairyFree: Boolean? = null,
    @SerialName("diets")
    val diets: List<String>? = null,
    @SerialName("dishTypes")
    val dishTypes: List<String>? = null,
    @SerialName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredient>? = null,
    @SerialName("gaps")
    val gaps: String? = null,
    @SerialName("glutenFree")
    val glutenFree: Boolean? = null,
    @SerialName("healthScore")
    val healthScore: Double? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("imageType")
    val imageType: String? = null,
    @SerialName("instructions")
    val instructions: String? = null,
    @SerialName("license")
    val license: String? = null,
    @SerialName("lowFodmap")
    val lowFodmap: Boolean? = null,
    @SerialName("pricePerServing")
    val pricePerServing: Double? = null,
    @SerialName("readyInMinutes")
    val readyInMinutes: Int? = null,
    @SerialName("servings")
    val servings: Int? = null,
    @SerialName("sourceName")
    val sourceName: String? = null,
    @SerialName("sourceUrl")
    val sourceUrl: String? = null,
    @SerialName("spoonacularScore")
    val spoonacularScore: Double? = null,
    @SerialName("spoonacularSourceUrl")
    val spoonacularSourceUrl: String? = null,
    @SerialName("summary")
    val summary: String? = null,
    @SerialName("sustainable")
    val sustainable: Boolean? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("vegan")
    val vegan: Boolean? = null,
    @SerialName("vegetarian")
    val vegetarian: Boolean? = null,
    @SerialName("veryHealthy")
    val veryHealthy: Boolean? = null,
    @SerialName("veryPopular")
    val veryPopular: Boolean? = null,
    @SerialName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int? = null
)