package com.example.whattocook.data

import com.example.whattocook.Recipe

interface FavouritesDao {

    /**
     * add [recipe] to favourites
     */
    fun add(recipe: Recipe)

    /**
     * delete [recipe] from favourites
     */
    fun delete(recipe: Recipe)

    /**
     * @return all recipes from favourites
     * may be empty
     */
    fun getAll(): List<Recipe>

    /**
     * @return true if the recipe is in favourites
     */
    fun isInFavourites(recipe: Recipe): Boolean

}

