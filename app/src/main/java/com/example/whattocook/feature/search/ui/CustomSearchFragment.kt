package com.example.whattocook.feature.search.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.whattocook.R
import com.example.whattocook.databinding.FragmentCustomSearchBinding
import com.example.whattocook.feature.search.presentation.CustomSearchPresenter
import com.example.whattocook.feature.search.presentation.CustomSearchView
import kotlinx.android.synthetic.main.fragment_custom_search.*

class CustomSearchFragment : Fragment(R.layout.fragment_custom_search), CustomSearchView {

    private val presenter = CustomSearchPresenter()
    private lateinit var binding: FragmentCustomSearchBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        initListeners()
    }

    private fun initListeners() {

        binding = FragmentCustomSearchBinding.bind(requireView())
        val selectedCategory: String = binding.spinnerCategories.selectedItem.toString()
        val selectedArea: String = binding.spinnerAreas.selectedItem.toString()
        val ingredients = requireContext().resources.getStringArray(R.array.ingredientNames)

        presenter.setCategory(selectedCategory)
        presenter.setArea(selectedArea)

       binding.btnSearch.setOnClickListener {
            presenter.validate(
                    etIngredients.text.toString(),
                    ingredients
            )
        }
    }

    override fun showIngredientsError() {
        Toast.makeText(requireContext(), "Unknown ingredient", Toast.LENGTH_SHORT).show()
    }

}