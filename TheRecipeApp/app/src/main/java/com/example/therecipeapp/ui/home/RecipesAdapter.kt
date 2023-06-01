package com.example.therecipeapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.therecipeapp.R
import com.example.therecipeapp.databinding.ItemRecipeBinding
import com.example.therecipeapp.domain.models.Recipes

import com.squareup.picasso.Picasso

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    var favoriteRecipes: MutableList<Recipes> = mutableListOf()

    var recipes: List<Recipes> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecipeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        with(holder.binding) {
            recipeName.text = recipe.title
            val dishTypes = recipe.dishTypes.joinToString(", ")
            recipeDescription.text = dishTypes
            recipeTime.text = recipe.readyInMinutes.toString()
            recipeLikes.text = recipe.aggregateLikes.toString()
            healthScoreTextView.text = getHealthScoreLabel(recipe.healthScore ?: 0)
            healthScoreProgressbar.progress = recipe.healthScore ?: 0
            Picasso.get().load(recipe.image).into(recipeAvatar)

            root.setOnClickListener {
                val recipeId = bundleOf(Pair("recipe_id", recipe.id.toString()))
                it.findNavController().navigate(R.id.homeToDetail, recipeId)
            }
        }

    }

    override fun getItemCount(): Int = recipes.size


    private fun getHealthScoreLabel(healthScore: Int): String {
        return when (healthScore) {
            in 0..19 -> "Junky"
            in 20..39 -> "Unhealthy"
            in 40..59 -> "Neutral"
            in 60..79 -> "Healthy"
            in 80..100 -> "Very Healthy"
            else -> "Unknown"
        }
    }


}