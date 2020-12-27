package com.example.whattocook.feature.recipesList.presentation

import com.example.whattocook.Recipe
import com.example.whattocook.domain.GetRecipesListUseCase
import com.example.whattocook.extensions.launchWithErrorHandler
import moxy.MvpPresenter
import moxy.presenterScope

class RecipesListPresenter(
        private val number: Int,
        private val filters: String,
        private val getRecipesListUseCase: GetRecipesListUseCase
) : MvpPresenter<RecipesListView>()  {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading(isShow = true)
        presenterScope.launchWithErrorHandler(block = {
            val recipes = getRecipesListUseCase(number, filters)
            viewState.setRecipes(recipes)
            viewState.showLoading(isShow = false)
        }, onError = {
            viewState.showLoading(isShow = false)
        })
    }


    fun onRecipeClick(recipe: Recipe) {
        viewState.openRecipeDetails(recipe)
    }

    fun onFavouritesClick() {
        viewState.openFavourites()
    }
}

