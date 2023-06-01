package com.example.therecipeapp.ui.detail

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.therecipeapp.R

import com.example.therecipeapp.databinding.DetailFragmentBinding
import com.example.therecipeapp.domain.models.Ingredients
import com.example.therecipeapp.domain.models.Recipes
import com.example.therecipeapp.ui.home.HomeViewModel
import com.example.therecipeapp.ui.home.RecipesAdapter
import com.squareup.picasso.Picasso

class FragmentDetail : Fragment() {
    val recipesData = MutableLiveData<Recipes>()
    lateinit var binding: DetailFragmentBinding
    val args: FragmentDetailArgs by navArgs()
    val viewModel: DetailViewModel by viewModels()
    private val adapter = IngredientsAdapter()
    lateinit var layoutManager: LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val charId = args.recipeId
        viewModel.getRecipeById(charId.toString())
        observeViewModel()


        with(binding) {
            layoutManager = LinearLayoutManager(activity)
            ingredientsList.adapter = adapter
            ingredientsList.layoutManager = layoutManager
        }

    }

    private fun observeViewModel() {
        viewModel.recipeData.observe(viewLifecycleOwner) {
            setupUi(it)
        }
        viewModel.ingredientsList.observe(viewLifecycleOwner) {
            adapter.ingredients = it as List<Ingredients>
        }


    }


    private fun setupUi(recipes: Recipes) {
        with(binding) {
            Picasso.get().load(recipes.image).into(recipeDetailAvatar)
            recipeNameTextView.text = recipes.title

            if (recipes.vegetarian == true) {
                vegetarianIcon.setImageResource(R.drawable.ic_leaf)
            }
            if (recipes.vegan == true) {
                veganIcon.setImageResource(R.drawable.ic_leaf)
            }
            if (recipes.glutenFree == true) {
                glutenIcon.setImageResource(R.drawable.ic_leaf)
            }
            if (recipes.dairyFree == true) {
                dairyIcon.setImageResource(R.drawable.ic_leaf)
            }
            if (recipes.veryHealthy == true) {
                healthyIcon.setImageResource(R.drawable.ic_leaf)
            }
            if (recipes.cheap == true) {
                cheapIcon.setImageResource(R.drawable.ic_leaf)
            }

            descriptionTextView.text = Html.fromHtml(recipes.summary)

            //recipeSteps.text = recipes.instructions
            recipeSteps.text = Html.fromHtml(recipes.instructions)


            val layoutManager = LinearLayoutManager(activity)
            viewModel.ingredientsLiveData.observe(viewLifecycleOwner) {
                adapter.ingredients = it
            }

        }


    }
}