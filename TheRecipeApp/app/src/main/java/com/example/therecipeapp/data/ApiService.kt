package com.example.therecipeapp.data

import com.example.therecipeapp.domain.models.Recipes
import com.example.therecipeapp.domain.models.RecipesResponse

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("recipes/{recipe_id}/{information}")
    suspend fun getRecipeById(
        @Path("recipe_id") recipeId: String,
        @Path("information") information: String,
        @Query("apiKey") apiKey: String
    ): Recipes


    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("apiKey") apiKey: String,
        @Query("number") number: String
    ): RecipesResponse


    @GET("recipes/{ingredient_id}/ingredientWidget.json")
    suspend fun getIngredientsById(
        @Path("ingredient_id") ingredientId: String,
        @Query("apiKey") apiKey: String
    )

}