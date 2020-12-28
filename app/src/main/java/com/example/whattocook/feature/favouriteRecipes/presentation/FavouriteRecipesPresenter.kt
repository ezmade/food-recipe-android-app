package com.example.whattocook.feature.favouriteRecipes.presentation

import com.example.whattocook.Recipe
import com.example.whattocook.data.FavouritesDao
import moxy.MvpPresenter

class FavouriteRecipesPresenter(
        private val favouritesDao: FavouritesDao
) : MvpPresenter<FavouriteRecipesView>()  {

    private var recipes: List<Recipe> = emptyList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        recipes = favouritesDao.getAll()
        viewState.setRecipes(recipes)
    }

    fun onRecipeClick(recipe: Recipe) {
        viewState.openRecipeDetails(recipe)
    }


}
