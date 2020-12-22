package com.example.whattocook.feature.recipeDetails.presentation

import com.example.whattocook.Recipe
import com.example.whattocook.data.FavouritesDao
import com.example.whattocook.feature.recipeDetails.ui.RecipeDetailsFragment
import moxy.MvpPresenter

class RecipeDetailsPresenter(
        private val recipe: Recipe,
        private val favouritesDao: FavouritesDao
) : MvpPresenter<RecipeDetailsView>() {

    private var isInFavourites: Boolean = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setRecipe(recipe)
        isInFavourites = favouritesDao.isInFavourites(recipe)
        viewState.setIsInFavourites(isInFavourites)
    }

    fun onFavouriteClicked() {
        if (isInFavourites) {
            favouritesDao.delete(recipe)
        }
        else {
            favouritesDao.add(recipe)
        }
        isInFavourites = !isInFavourites
        viewState.setIsInFavourites(isInFavourites)
    }
}