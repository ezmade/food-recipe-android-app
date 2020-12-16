package com.example.whattocook.feature.search.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface CustomSearchView : MvpView {

    @Skip
    fun showIngredientsError()

}