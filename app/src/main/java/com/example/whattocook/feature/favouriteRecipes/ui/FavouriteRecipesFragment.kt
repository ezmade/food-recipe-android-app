package com.example.whattocook.feature.favouriteRecipes.ui

import android.content.Context
import android.os.Bundle

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whattocook.R
import com.example.whattocook.Recipe
import com.example.whattocook.data.FavouritesDaoImpl
import com.example.whattocook.databinding.FragmentFavouriteRecipesBinding
import com.example.whattocook.feature.favouriteRecipes.presentation.FavouriteRecipesPresenter
import com.example.whattocook.feature.favouriteRecipes.presentation.FavouriteRecipesView
import com.example.whattocook.feature.recipeDetails.ui.RecipeDetailsFragment
import com.example.whattocook.feature.recipesList.ui.RecipesListAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class FavouriteRecipesFragment : MvpAppCompatFragment(R.layout.fragment_favourite_recipes), FavouriteRecipesView {

    companion object {
        fun newInstance() = FavouriteRecipesFragment()
    }

    private lateinit var binding: FragmentFavouriteRecipesBinding
    private val presenter: FavouriteRecipesPresenter by moxyPresenter {
        FavouriteRecipesPresenter(
                favouritesDao = FavouritesDaoImpl(
                        requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
                )
        )
    }

    private var favouriteRecipesAdapter : RecipesListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouriteRecipesBinding.bind(view)
        with(binding.rvRecipesList) {
            favouriteRecipesAdapter = RecipesListAdapter(context, onRecipeClick = {
                presenter.onRecipeClick(it)
            })
            layoutManager = LinearLayoutManager(context)
            adapter = favouriteRecipesAdapter
            }
        }

    override fun openRecipeDetails(recipe: Recipe) {
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, RecipeDetailsFragment.newInstance(recipe))
            .addToBackStack("RecipeDetailsFragment")
            .commit()
    }

    override fun setRecipes(recipe: List<Recipe>) {
        favouriteRecipesAdapter?.setData(recipe)
    }
}

