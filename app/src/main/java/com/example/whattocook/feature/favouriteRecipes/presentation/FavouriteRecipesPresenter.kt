package com.example.whattocook.feature.favouriteRecipes.presentation

import com.example.whattocook.Recipe
import com.example.whattocook.data.FavouritesDao
import moxy.MvpPresenter

class FavouriteRecipesPresenter(
        private val favouritesDao: FavouritesDao
) : MvpPresenter<FavouriteRecipesView>()  {

    private var recipeData: List<Recipe> = emptyList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        recipeData = favouritesDao.getAll()
        viewState.setRecipes(recipeData)
    }

    fun onRecipeClick(recipe: Recipe) {
        viewState.openRecipeDetails(recipe)
    }


}
