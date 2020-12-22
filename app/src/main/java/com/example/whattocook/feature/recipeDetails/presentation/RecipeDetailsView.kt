package com.example.whattocook.feature.recipeDetails.presentation

import com.example.whattocook.Recipe
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface RecipeDetailsView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setRecipe(recipe: Recipe)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setIsInFavourites(inFavourites: Boolean)

}
