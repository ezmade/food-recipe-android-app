package com.example.whattocook.feature.search.presentation

import moxy.MvpPresenter


class CustomSearchPresenter : MvpPresenter<CustomSearchView>() {

    fun validate(
            selectedDietType: String,
            selectedDishType: String,
            numberOfRecipes: String
    ) {
        try {
            val number = numberOfRecipes.toInt()
            var tags = ""

            if ((number < 1) || (number > 100)) {
                viewState.showNumberOfRecipesError()
            } else
                tags = if ((selectedDietType != "") && (selectedDishType != ""))
                        "$selectedDietType,$selectedDishType"
                    else if (selectedDietType != "")
                        selectedDietType
                    else
                        selectedDishType

                viewState.setFilters(number, tags)
        } catch(t: Throwable) {
            viewState.showNumberOfRecipesError()
        }
    }
}