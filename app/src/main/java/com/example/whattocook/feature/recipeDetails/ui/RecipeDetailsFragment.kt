package com.example.whattocook.feature.recipeDetails.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.whattocook.R
import com.example.whattocook.Recipe
import com.example.whattocook.databinding.FragmentRecipeDetailsBinding

class RecipeDetailsFragment : Fragment(R.layout.fragment_recipe_details) {

    companion object {

        private const val RECIPE = "RECIPE"

        fun newInstance(recipe: Recipe) =
            RecipeDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(RECIPE, recipe)
                }
            }
    }

    private lateinit var binding: FragmentRecipeDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipeDetailsBinding.bind(view)
        arguments?.let {
            val recipe = it.getParcelable<Recipe>(RECIPE)
            binding.recipeName.text =recipe?.name
            binding.recipeCategory.text = "Category: ${recipe?.category}"
            binding.recipeTotalPrice.text = "Area: ${recipe?.area}"
        }
    }
}