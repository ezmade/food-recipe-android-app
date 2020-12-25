package com.example.whattocook.data.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExtendedIngredient(
    @SerialName("aisle")
    val aisle: String? = null,
    @SerialName("amount")
    val amount: Double? = null,
    @SerialName("consistency")
    val consistency: String? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("measures")
    val measures: Measures? = null,
    @SerialName("meta")
    val meta: List<String>? = null,
    @SerialName("metaInformation")
    val metaInformation: List<String>? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("original")
    val original: String? = null,
    @SerialName("originalName")
    val originalName: String? = null,
    @SerialName("originalString")
    val originalString: String? = null,
    @SerialName("unit")
    val unit: String? = null
)