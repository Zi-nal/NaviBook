package com.dsm.navibook.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dsm.navibook.model.RecipeModel
import com.dsm.navibook.RecyclerViewAdapter
import com.dsm.navibook.databinding.ActivityRecipeCreateBinding
import com.dsm.navibook.viewmodel.RecipeViewModel

class RecipeCreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeCreateBinding
    private lateinit var mViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initAddButton()
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(RecipeViewModel::class.java)
    }

    private fun initAddButton() {
        binding.add.setOnClickListener {
            val title = binding.title.text.toString()
            val time = binding.time.text.toString()
            val type = binding.type.text.toString()
            val ingredient = binding.ingredient.text.toString()
            val condiment = binding.condiment.text.toString()
            val content = binding.content.text.toString()

            val recipeModel = RecipeModel(null, title, time, type, ingredient, condiment, content)
            mViewModel.insertRecipe(recipeModel)
            finish()
        }
    }
}
