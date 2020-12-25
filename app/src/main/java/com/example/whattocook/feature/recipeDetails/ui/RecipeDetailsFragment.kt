package com.example.whattocook.feature.recipeDetails.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.whattocook.R
import com.example.whattocook.Recipe
import com.example.whattocook.data.FavouritesDaoImpl
import com.example.whattocook.databinding.FragmentRecipeDetailsBinding
import com.example.whattocook.feature.recipeDetails.presentation.RecipeDetailsPresenter
import com.example.whattocook.feature.recipeDetails.presentation.RecipeDetailsView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_recipe_details.*
import kotlinx.android.synthetic.main.recipes_list_item.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RecipeDetailsFragment : MvpAppCompatFragment(R.layout.fragment_recipe_details),
        RecipeDetailsView {

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
    private val presenter: RecipeDetailsPresenter by moxyPresenter {
        RecipeDetailsPresenter(
                recipe = arguments?.getParcelable(RECIPE)!!,
                favouritesDao = FavouritesDaoImpl(
                        requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
                )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipeDetailsBinding.bind(view)
        binding.addToFavourites.setOnClickListener{
            presenter.onFavouriteClicked()
        }
    }

    override fun setRecipe(recipe: Recipe) {
        Picasso.with(context)
                .load(recipe.img)
                .priority(Picasso.Priority.HIGH)
                .resize(300, 300)
                .centerCrop()
                .into(binding.recipesImage)
        binding.recipeName.text = recipe.name
        binding.recipeTimeReady.text = "${recipe.ready} min"
        binding.recipeInstructions.text = recipe.instructions
    }

    override fun setIsInFavourites(inFavourites: Boolean) {
        binding.addToFavourites.setImageResource(
                if (inFavourites) R.drawable.ic_baseline_favourite_filled else R.drawable.ic_baseline_favourite
        )
    }
}