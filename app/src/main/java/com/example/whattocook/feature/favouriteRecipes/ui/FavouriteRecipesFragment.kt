package com.example.whattocook.feature.favouriteRecipes.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whattocook.R
import com.example.whattocook.Recipe
import com.example.whattocook.databinding.FragmentFavouriteRecipesBinding
import com.example.whattocook.feature.favouriteRecipes.presentation.FavoriteRecipesView
import com.example.whattocook.feature.favouriteRecipes.presentation.FavouriteRecipesPresenter
import com.example.whattocook.feature.recipeDetails.ui.RecipeDetailsFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class FavouriteRecipesFragment : MvpAppCompatFragment(R.layout.fragment_favourite_recipes), FavoriteRecipesView{

    val recipe = Recipe("Carbonara", "Pasta", "Italian")
    private lateinit var binding: FragmentFavouriteRecipesBinding
    private val presenter: FavouriteRecipesPresenter by moxyPresenter {
        FavouriteRecipesPresenter()
    }
    private var favouriteRecipesAdapter : FavouriteRecipesAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouriteRecipesBinding.bind(view)
        with(binding.rvRecipesList) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = FavouriteRecipesAdapter(onRecipeClick = { recipe ->
                presenter.onRecipeClick(recipe)
            }).also {
                favouriteRecipesAdapter = it
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        favouriteRecipesAdapter = null
    }

    override fun setRecipes(recipes: List<Recipe>) {
        favouriteRecipesAdapter?.submitList(recipes)
    }

    override fun openRecipeDetails(recipe: Recipe) {
        requireFragmentManager().beginTransaction()
                .replace(R.id.container, RecipeDetailsFragment.newInstance(recipe))
                .addToBackStack("RecipeDetailsFragment")
                .commit()
    }
}

