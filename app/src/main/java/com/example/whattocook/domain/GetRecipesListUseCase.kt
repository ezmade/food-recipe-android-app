package com.example.whattocook.domain

import com.example.whattocook.Recipe
import com.example.whattocook.di.RecipesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetRecipesListUseCase(
        private val recipesApi: RecipesApi,
) {

    suspend operator fun invoke(
            number: Int,
            filters: String
    ): List<Recipe> = withContext(Dispatchers.IO) {
            recipesApi.getRecipesList(
                    number = number,
                    tags = filters
            ).run {
                recipes?.mapNotNull { recipe ->
                    Recipe(
                        id = recipe.id,
                        name = recipe.title ?: return@mapNotNull null,
                        category = (recipe.dishTypes ?: return@mapNotNull null).toString(),
                        ready = recipe.readyInMinutes ?: return@mapNotNull null,
                        price = recipe.pricePerServing ?: return@mapNotNull null,
                        img = recipe.image ?: return@mapNotNull null,
                        instructions = recipe.instructions ?: return@mapNotNull null,
                        url = recipe.spoonacularSourceUrl ?: return@mapNotNull null
                    )
                } ?: emptyList()
            }
    }
}