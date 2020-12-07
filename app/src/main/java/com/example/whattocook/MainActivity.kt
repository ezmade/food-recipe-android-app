package com.example.whattocook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnViewRecipe: Button = findViewById(R.id.btnViewRecipe)

        btnViewRecipe.setOnClickListener {
            val recipe = Recipe("Carbonara", "Pasta", 120)

            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putExtra("Recipe", recipe)
            startActivity(intent)
        }
    }


}