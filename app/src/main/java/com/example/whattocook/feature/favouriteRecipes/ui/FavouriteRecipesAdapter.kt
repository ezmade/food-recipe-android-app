package com.example.whattocook.feature.favouriteRecipes.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.whattocook.R
import com.example.whattocook.Recipe
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recipes_list_item.*

class FavouriteRecipesAdapter(private val onRecipeClick: (Recipe) -> Unit) :
        ListAdapter<Recipe, FavouriteRecipesAdapter.ViewHolder>(
                object : DiffUtil.ItemCallback<Recipe>() {
                    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
                        return oldItem.name == newItem.name
                    }

                    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
                        return oldItem == newItem
                    }
                }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.recipes_list_item,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.recipesListName.text = item.name
        holder.recipesListCategory.text = item.category
        holder.recipesListArea.text = item.area
        holder.containerView.setOnClickListener {
            onRecipeClick(item)
        }
    }

    class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),
            LayoutContainer
}