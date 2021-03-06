package com.example.whattocook.feature.recipesList.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whattocook.R
import com.example.whattocook.Recipe
import com.example.whattocook.databinding.FragmentRecipesListBinding
import com.example.whattocook.di.RECIPES_API
import com.example.whattocook.domain.GetRecipesListUseCase
import com.example.whattocook.feature.favouriteRecipes.ui.FavouriteRecipesFragment
import com.example.whattocook.feature.recipeDetails.ui.RecipeDetailsFragment
import com.example.whattocook.feature.recipesList.presentation.RecipesListPresenter
import com.example.whattocook.feature.recipesList.presentation.RecipesListView
import com.example.whattocook.feature.search.ui.CustomSearchFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RecipesListFragment : MvpAppCompatFragment(R.layout.fragment_recipes_list), RecipesListView {

    companion object {

        private const val FILTERS = "FILTERS"
        private const val NUMBER = "NUMBER"

        fun newInstance(
                number: Int,
                filters: String
        ) = RecipesListFragment().apply {
                    arguments = Bundle().apply {
                        putInt(NUMBER, number)
                        putString(FILTERS, filters)
                    }
                }
    }


    private var binding: FragmentRecipesListBinding? = null
    private val presenter: RecipesListPresenter by moxyPresenter {
        RecipesListPresenter(
                arguments?.getInt(NUMBER) ?: 25,
                arguments?.getString(FILTERS) ?: "",
                GetRecipesListUseCase(RECIPES_API))
    }
    private var recipesAdapter: RecipesListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipesListBinding.bind(view)

        with(binding!!.rvRecipesList) {
            layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false)

            adapter = RecipesListAdapter(context, onRecipeClick = { recipe ->
                presenter.onRecipeClick(recipe)
            }).also {
                recipesAdapter = it
            }
        }

        binding!!.btnCustomSearch.setOnClickListener {
            openCustomSearch()
        }

        binding!!.btnViewFavourites.setOnClickListener {
            presenter.onFavouritesClick()
        }

    }

    override fun onDestroyView() {
        recipesAdapter = null
        binding = null
        super.onDestroyView()
    }

    override fun setRecipes(recipeData: List<Recipe>) {
        recipesAdapter?.setData(recipeData)
    }

    override fun showLoading(isShow: Boolean) {
        binding!!.recipesListProgressBar.isVisible = isShow
    }

    override fun openRecipeDetails(recipe: Recipe) {
        requireFragmentManager().beginTransaction()
                .replace(R.id.container, RecipeDetailsFragment.newInstance(recipe))
                .addToBackStack("RecipeDetailsFragment")
                .commit()
    }

    override fun openFavourites() {
        requireFragmentManager().beginTransaction()
                .replace(R.id.container, FavouriteRecipesFragment())
                .addToBackStack("FavouriteRecipesFragment")
                .commit()
    }

    private fun openCustomSearch() {
        requireFragmentManager().beginTransaction()
                .replace(R.id.container, CustomSearchFragment())
                .addToBackStack("CustomSearchFragment")
                .commit()
    }
}

