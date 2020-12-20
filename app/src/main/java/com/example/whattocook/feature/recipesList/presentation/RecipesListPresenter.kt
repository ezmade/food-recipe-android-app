package com.example.whattocook.feature.recipesList.presentation

import com.example.whattocook.Recipe
import moxy.MvpPresenter

class RecipesListPresenter : MvpPresenter<RecipesListView>()  {

    private val recipes = listOf(
            Recipe("Carbonara", "Pasta", "Italian"),
            Recipe("BeaverTails", "Desert", "Canadian"),
            Recipe("Peanut Butter Cookies", "Dessert", "American"),
            Recipe("Beef stroganoff", "Beef", "Russian"),
            Recipe("Chocolate Caramel Crispy", "Dessert", "British"),
            Recipe("Stamppot", "Pork", "Dutch")
    )

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setRecipes(recipes)
    }

    fun onRecipeClick(recipe: Recipe) {
        viewState.openRecipeDetails(recipe)
    }
}

