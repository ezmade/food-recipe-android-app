package com.example.whattocook.feature.recipesList.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whattocook.R
import com.example.whattocook.Recipe
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recipes_list_item.*

class RecipesListAdapter(
        private val context: Context,
        private val onRecipeClick: (Recipe) -> Unit) :
        RecyclerView.Adapter<RecipesListAdapter.ViewHolder>() {

    private val recipes: MutableList<Recipe> = mutableListOf()

    fun setData(recipes: List<Recipe>) {
        this.recipes.clear()
        this.recipes.addAll(recipes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.recipes_list_item,
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = recipes[position]
        Picasso.with(context)
            .load(item.img)
            .priority(Picasso.Priority.HIGH)
            .resize(100, 100)
            .centerCrop()
            .into(holder.recipesImage)
        holder.recipesListName.text = item.name
        holder.recipesListTimeReady.text = "${item.ready} min"
        holder.recipesListPrice.text = String.format("%.2f", item.price / 100)
        holder.containerView.setOnClickListener {
            onRecipeClick(item)
        }
    }

    override fun getItemCount(): Int = recipes.size

    class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),
        LayoutContainer
}