package com.example.whattocook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RecipeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val recipeName: TextView = findViewById(R.id.recipeName)
        val recipeCategory: TextView = findViewById(R.id.recipeCategory)
        val recipeTotalPrice: TextView = findViewById(R.id.recipeTotalPrice)
        val recipe = intent.extras?.getSerializable("Recipe") as Recipe

        recipeName.text = "Meal: ${recipe.name}"
        recipeCategory.text = "Category: ${recipe.category}"
        recipeTotalPrice.text = "Price: ${recipe.totalPrice}"
    }
}