package com.example.whattocook

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Recipe(
        val id: Int?,
        val name: String,
        val category: String = "Others",
        val ready: Int = 0,
        val img: String = "",
        val instructions: String = "",
        val url: String = "",
        val price: Double
): Parcelable