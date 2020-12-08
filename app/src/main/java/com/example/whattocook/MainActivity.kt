package com.example.whattocook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whattocook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnViewRecipe.setOnClickListener {
            val recipe = Recipe("Carbonara", "Pasta", 120)
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putExtra("Recipe", recipe)
            startActivity(intent)
        }
    }
}