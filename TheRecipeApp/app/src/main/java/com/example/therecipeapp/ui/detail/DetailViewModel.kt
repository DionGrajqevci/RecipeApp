package com.example.therecipeapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.therecipeapp.domain.models.Ingredients
import com.example.therecipeapp.domain.models.Recipes
import com.example.therecipeapp.domain.repo.RecipesRepo


import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    val recipeData = MutableLiveData<Recipes>()
    val ingredientsList = MutableLiveData<List<Ingredients>>()
    private val recipesRepository = RecipesRepo()
    val ingredientsLiveData = MutableLiveData<List<Ingredients>>()


   fun getRecipeById(recipeId: String) {
       viewModelScope.launch {
           val recipe = recipesRepository.getSingleRecipe(recipeId)
           recipeData.value = recipe
           recipe?.let {
               val ingredients = it.extendedIngredients.map { extendedIngredient ->
                   Ingredients(
                       id = extendedIngredient.id,
                       name = extendedIngredient.name,
                       localizedName = extendedIngredient.nameClean,
                       image = extendedIngredient.image
                   )
               }
               ingredientsList.value = ingredients
           }
       }
   }



}