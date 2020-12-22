package com.example.whattocook

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Recipe (
    val name: String,
    val category: String = "Others",
    val area: String = "Unknown",
): Parcelable