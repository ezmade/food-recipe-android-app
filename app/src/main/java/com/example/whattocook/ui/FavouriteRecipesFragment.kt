package com.example.whattocook.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whattocook.R

class FavouriteRecipesFragment : Fragment(R.layout.fragment_favourite_recipes) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object {

        fun newInstance(param1: String, param2: String) =
                FavouriteRecipesFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}