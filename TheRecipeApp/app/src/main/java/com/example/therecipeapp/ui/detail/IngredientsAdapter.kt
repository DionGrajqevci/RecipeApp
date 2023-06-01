package com.example.therecipeapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.therecipeapp.R
import com.example.therecipeapp.databinding.ItemIngredientBinding
import com.example.therecipeapp.databinding.ItemRecipeBinding
import com.example.therecipeapp.domain.models.Ingredients
import com.example.therecipeapp.domain.models.Recipes
import com.example.therecipeapp.ui.home.RecipesAdapter
import com.squareup.picasso.Picasso

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {


    var ingredients: List<Ingredients> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class ViewHolder(val binding: ItemIngredientBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientsAdapter.ViewHolder {
        val binding = ItemIngredientBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientsAdapter.ViewHolder, position: Int) {
        val ingredients = ingredients[position]
        with(holder.binding) {
            ingredientName.text = ingredients.name
            ingredientDescription.text = ingredients.localizedName
            Picasso.get()
                .load("https://spoonacular.com/cdn/ingredients_500x500/" + ingredients.image)
                .into(ingredientImage)

        }

    }

    override fun getItemCount(): Int = ingredients.size


}

