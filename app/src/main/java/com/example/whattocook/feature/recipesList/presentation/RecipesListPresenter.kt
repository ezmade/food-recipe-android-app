package com.example.whattocook.feature.recipesList.presentation

import android.util.Log
import com.example.whattocook.Recipe
import com.example.whattocook.domain.GetRecipesListUseCase
import com.example.whattocook.extensions.launchWithErrorHandler
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope

class RecipesListPresenter(
       private val getRecipesListUseCase: GetRecipesListUseCase
) : MvpPresenter<RecipesListView>()  {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading(isShow = true)
        presenterScope.launchWithErrorHandler(block = {
            val recipes = getRecipesListUseCase()
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

