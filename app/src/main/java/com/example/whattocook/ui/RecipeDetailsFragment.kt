package com.example.whattocook.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whattocook.R
import com.example.whattocook.Recipe
import com.example.whattocook.databinding.FragmentRecipeDetailsBinding
import com.example.whattocook.databinding.FragmentRecipesListBinding

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
            binding.recipeName.text ="Meal: ${recipe?.name}"
            binding.recipeCategory.text = "Category: ${recipe?.category}"
            binding.recipeTotalPrice.text = "Price: ${recipe?.totalPrice}"
        }
    }
}