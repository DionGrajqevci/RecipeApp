package com.example.therecipeapp.domain.repo


import com.example.therecipeapp.data.ApiService
import com.example.therecipeapp.domain.models.Recipes
import com.example.therecipeapp.domain.models.RecipesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipesRepo {
    private val apiService: ApiService
    val apiKey: String = "c33aa3eece3d464e9c4979968dacb6ef"
    val apiKey2: String = "22edf63cd0384f8fa1306603c7050779"
    val apiKey3: String = "76253d112b0c4417b2830a38c3e5bb80" //apiKey i Elonit

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }


    suspend fun getSingleRecipe(recipeId: String):
            Recipes {
        return apiService.getRecipeById(recipeId, "information", apiKey)
    }


    suspend fun getRandomRecipes(): RecipesResponse {
        return apiService.getRandomRecipes(apiKey, "40")
    }


}