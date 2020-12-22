package com.example.whattocook.feature.search.presentation

import moxy.MvpView
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.Skip

interface CustomSearchView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showIngredientsError()

}