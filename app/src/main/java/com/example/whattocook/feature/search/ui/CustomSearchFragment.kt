package com.example.whattocook.feature.search.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.whattocook.R
import com.example.whattocook.databinding.FragmentCustomSearchBinding
import com.example.whattocook.feature.recipesList.ui.RecipesListFragment
import com.example.whattocook.feature.search.presentation.CustomSearchPresenter
import com.example.whattocook.feature.search.presentation.CustomSearchView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class CustomSearchFragment : MvpAppCompatFragment(R.layout.fragment_custom_search), CustomSearchView {

    private val presenter : CustomSearchPresenter by moxyPresenter {
        CustomSearchPresenter()
    }
    private lateinit var binding: FragmentCustomSearchBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        initListeners()
    }

    private fun initListeners() {
        var selectedDietType: String
        var selectedDishType: String

        binding = FragmentCustomSearchBinding.bind(requireView())
        binding.btnSearch.setOnClickListener {
            selectedDietType = binding.spinnerDietType.selectedItem.toString()
            selectedDishType = binding.spinnerDishType.selectedItem.toString()
            presenter.validate(
                    selectedDietType,
                    selectedDishType,
                    binding.etNumbersOfRecipes.text.toString()
            )
        }
    }

    override fun setFilters(number: Int, tags: String) {
        requireFragmentManager().beginTransaction()
                .replace(R.id.container, RecipesListFragment.newInstance(number, tags))
                .addToBackStack("RecipesListFragment")
                .commit()
    }

    override fun showNumberOfRecipesError() {
        Toast.makeText(requireContext(), "Invalid number of recipes", Toast.LENGTH_SHORT).show()
    }

}