package com.example.whattocook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whattocook.databinding.ActivityMainBinding
import com.example.whattocook.ui.FavouriteRecipesFragment
import com.example.whattocook.ui.RecipesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
            .add(R.id.container, RecipesListFragment())
            .commit()
    }
}