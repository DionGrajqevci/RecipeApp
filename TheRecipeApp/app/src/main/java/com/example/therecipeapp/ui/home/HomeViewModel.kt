package com.example.therecipeapp.ui.home

import com.example.therecipeapp.domain.models.Recipes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.therecipeapp.domain.models.RecipesResponse
import com.example.therecipeapp.domain.repo.RecipesRepo

import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var currentPage = 1
    private val repo = RecipesRepo()
    private val recipesList = ArrayList<Recipes>()
    private val searchResults = ArrayList<Recipes>()
    val favoriteRecipes: MutableList<Recipes> = mutableListOf()

    val recipeLiveData = MutableLiveData<List<Recipes>>()


    fun getRandomRecipes() {
        viewModelScope.launch {
            val response = repo.getRandomRecipes()
            val recipesResponse = response.recipes
            recipesList.addAll(recipesResponse)
            recipeLiveData.value = recipesList
        }
    }


    fun loadMore() {
        currentPage++
        getRandomRecipes()
    }

    fun searchRecipes(query: String) {
        searchResults.clear()
        for (recipe in recipesList) {
            recipe.title?.let {
                if (it.startsWith(query, true)) {
                    searchResults.add(recipe)
                }
            }
        }
        recipeLiveData.value = searchResults
    }


}
