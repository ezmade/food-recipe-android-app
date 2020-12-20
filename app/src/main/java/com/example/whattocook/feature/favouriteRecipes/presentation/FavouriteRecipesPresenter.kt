package com.example.whattocook.feature.favouriteRecipes.presentation

import com.example.whattocook.Recipe
import moxy.MvpPresenter

class FavouriteRecipesPresenter : MvpPresenter<FavoriteRecipesView>()  {

    private var recipes = listOf(
            Recipe("Carbonara", "Pasta", "Italian"),
            Recipe("Beef stroganoff", "Beef", "Russian"),
            Recipe("Stamppot", "Pork", "Dutch")
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setRecipes(recipes)
    }

    fun onRecipeClick(recipe: Recipe) {
        recipes = recipes.filter { it != recipe }
        viewState.setRecipes(recipes)
    }
}
