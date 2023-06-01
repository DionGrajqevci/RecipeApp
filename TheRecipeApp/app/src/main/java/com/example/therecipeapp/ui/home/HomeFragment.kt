package com.example.therecipeapp.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.therecipeapp.databinding.HomeFragmentBinding
import com.example.therecipeapp.ui.home.RecipesAdapter


class HomeFragment : Fragment() {

    val apiKey: String = "c33aa3eece3d464e9c4979968dacb6ef"
    lateinit var binding: HomeFragmentBinding
    private val adapter = RecipesAdapter()
    lateinit var layoutManager: LinearLayoutManager
    private val viewModel: HomeViewModel by viewModels()
    private val args: HomeFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(
            layoutInflater,
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        viewModel.getRandomRecipes()
        with(binding) {
            layoutManager = LinearLayoutManager(activity)
            recipesList.adapter = adapter
            recipesList.layoutManager = layoutManager
            recipesList.addOnScrollListener(object : OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (searchBar.text.isEmpty() && layoutManager.findLastCompletelyVisibleItemPosition() > adapter.itemCount - 3) {
                        binding.loadMoreloader.visibility = View.VISIBLE
                        viewModel.loadMore()
                    }

                }
            })
            searchBar.doOnTextChanged { text, start, before, count ->
                viewModel.searchRecipes(text.toString())
            }
        }
    }

    private fun observeViewModel() {
        viewModel.recipeLiveData.observe(viewLifecycleOwner) {
            adapter.recipes = it
            binding.loader.visibility = View.GONE
            binding.loadMoreloader.visibility = View.GONE
        }
    }
}