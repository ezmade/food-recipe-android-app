package com.example.whattocook.feature.recipesList.presentation

import com.example.whattocook.Recipe
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.OneExecution

interface RecipesListView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setRecipes(recipes: List<Recipe>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openRecipeDetails(recipe: Recipe)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openFavourites()
}