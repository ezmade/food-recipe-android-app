package com.example.whattocook

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val carbonara = Recipe(name = "Carbonara", category = "Pasta", totalPrice = 300)
    val fishPie = Recipe(name = "Fish pie", category = "Seafood", totalPrice = 130)
    val madeiraCake = Recipe(name = "Madeira Cake", category = "Desert", totalPrice = 515)
    val collection = mutableListOf(carbonara, fishPie, madeiraCake)

    @Test
    fun start() {
        print(collection.sortByPrice())
    }

    fun List<Recipe>.sortByPrice(): List<Recipe> {
        return this.sortedBy { it.totalPrice }
    }
}