package com.example.whattocook.feature.recipesList.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.whattocook.R
import com.example.whattocook.Recipe
import com.example.whattocook.databinding.FragmentRecipesListBinding
import com.example.whattocook.feature.search.ui.CustomSearchFragment
import com.example.whattocook.feature.favouriteRecipes.ui.FavouriteRecipesFragment
import com.example.whattocook.feature.recipeDetails.ui.RecipeDetailsFragment

class RecipesListFragment : Fragment(R.layout.fragment_recipes_list) {

    private lateinit var binding: FragmentRecipesListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipe = Recipe("Carbonara", "Pasta", 360)

        binding = FragmentRecipesListBinding.bind(view)
        binding.btnViewRecipe.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, RecipeDetailsFragment.newInstance(recipe))
                .addToBackStack("RecipeDetailsFragment")
                .commit()
        }

        binding.btnCustomSearch.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, CustomSearchFragment())
                .addToBackStack("CustomSearchFragment")
                .commit()
        }

        binding.btnViewFavourites.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, FavouriteRecipesFragment())
                .addToBackStack("FavouriteRecipesFragment")
                .commit()
        }

    }
}