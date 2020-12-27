package com.example.whattocook.feature.recipeDetails.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.example.whattocook.R
import com.example.whattocook.Recipe
import com.example.whattocook.data.FavouritesDaoImpl
import com.example.whattocook.databinding.FragmentRecipeDetailsBinding
import com.example.whattocook.feature.recipeDetails.presentation.RecipeDetailsPresenter
import com.example.whattocook.feature.recipeDetails.presentation.RecipeDetailsView
import com.squareup.picasso.Picasso
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
        binding.btnViewOnWebsite.setOnClickListener {
            presenter.onViewOnWebsiteClicked(arguments?.getParcelable(RECIPE)!!)
        }
        binding.addToFavourites.setOnClickListener{
            presenter.onFavouriteClicked()
        }
    }

    override fun setRecipe(recipe: Recipe) {
        Picasso.with(context)
                .load(recipe.img)
                .resize(300, 300)
                .centerCrop()
                .into(binding.recipesImage)
        binding.recipeName.text = recipe.name
        binding.recipesTimeReady.text = "${recipe.ready} min"
        binding.recipesPrice.text = String.format("%.2f", recipe.price / 100)
        binding.recipeInstructions.text = recipe.instructions.formatted()
    }

    override fun openViewOnWebsite(recipe: Recipe) {
        val url = recipe.url
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun setIsInFavourites(inFavourites: Boolean) {
        binding.addToFavourites.setImageResource(
                if (inFavourites) R.drawable.ic_baseline_favourite_filled
                else R.drawable.ic_baseline_favourite
        )
    }
}

private fun String.formatted(): String {
    return "\t\t" + this
            .replace("<ol><li>", "")
            .replace("</li></ol>", "")
            .replace("</li><li>", "\n")
            .replace("\n\n", "\n")
            .replace("\n", "\n\n\t\t")
            .replace("Instructions", "")
            .replace("<ul><li>", "")
            .replace("<em>", "")
            .replace("<strong>", "")
            .replace("</strong>", "")
            .replace("</em>", "")
            .replace("</li></ul>", "")
}
