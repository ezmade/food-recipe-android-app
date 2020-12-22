package com.example.whattocook.data
import android.content.SharedPreferences
import com.example.whattocook.Recipe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class FavouritesDaoImpl(
        private val sharedPreferences: SharedPreferences
) : FavouritesDao {

    private var recipes: List<Recipe>
        get() = sharedPreferences.getString(FAVORITES_DAO_KEY, null)?.let {
            try {
                Json.decodeFromString(it)
            } catch (t: Throwable) {
                emptyList()
            }
        } ?: emptyList()
        set(value) {
            sharedPreferences.edit().putString(
                    FAVORITES_DAO_KEY,
                    Json.encodeToString(value)
            ).apply()
        }

    override fun add(recipe: Recipe) {
        recipes = recipes + recipe
    }

    override fun delete(recipe: Recipe) {
        recipes = recipes.filter { it != recipe }
    }

    override fun getAll(): List<Recipe> = recipes
    override fun isInFavourites(recipe: Recipe): Boolean = recipes.contains(recipe)

    companion object {

        private const val FAVORITES_DAO_KEY = "FAVORITES_DAO_KEY"
    }
}