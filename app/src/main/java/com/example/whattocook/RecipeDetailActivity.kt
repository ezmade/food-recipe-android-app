package com.example.whattocook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whattocook.databinding.ActivityRecipeDetailBinding

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recipe = intent.extras?.getSerializable("Recipe") as Recipe

        binding.recipeName.text = "Meal: ${recipe.name}"
        binding.recipeCategory.text = "Category: ${recipe.category}"
        binding.recipeTotalPrice.text = "Price: ${recipe.totalPrice}"
    }
}