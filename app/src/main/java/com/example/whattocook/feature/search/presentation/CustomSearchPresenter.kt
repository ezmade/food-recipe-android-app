package com.example.whattocook.feature.search.presentation

import moxy.MvpPresenter


class CustomSearchPresenter : MvpPresenter<CustomSearchView>() {

    private var selectedCategory = "Beef"
    private var selectedArea = "British"

    fun setCategory(selectedCategory: String) {
        this.selectedCategory = selectedCategory
    }

    fun setArea(selectedArea: String) {
        this.selectedArea = selectedArea
    }

    fun validate(ingredient: String, ingredientsList: Array<String>) {
        if (!ingredientsList.contains(ingredient)) {
            viewState.showIngredientsError()
        }
    }

}