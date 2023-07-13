package com.dsm.navibook.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dsm.navibook.R
import com.dsm.navibook.databinding.ActivityRecipeUpdateBinding
import com.dsm.navibook.model.RecipeModel
import com.dsm.navibook.viewmodel.RecipeViewModel

class RecipeUpdateActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecipeUpdateBinding
    private lateinit var mViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeUpdateBinding.inflate(layoutInflater)
        val id = intent.getLongExtra("id", 0)
        var title = intent.getStringExtra("title")
        var time = intent.getStringExtra("time")
        var type = intent.getStringExtra("type")
        var ingredient = intent.getStringExtra("ingredient")
        var condiment = intent.getStringExtra("condiment")
        var content = intent.getStringExtra("content")
        setContentView(binding.root)
        binding.title.setText(title)
        binding.time.setText(time)
        binding.type.setText(type)
        binding.ingredient.setText(ingredient)
        binding.condiment.setText(condiment)
        binding.content.setText(content)

        initViewModel()

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        binding.add.setOnClickListener {
            title = binding.title.text.toString()
            time = binding.time.text.toString()
            type = binding.type.text.toString()
            ingredient = binding.ingredient.text.toString()
            condiment = binding.condiment.text.toString()
            content = binding.content.text.toString()

            val recipeModel =
                RecipeModel(id, title!!, time!!, type!!, ingredient!!, condiment!!, content!!)
            mViewModel.updateRecipe(recipeModel)
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(RecipeViewModel::class.java)
    }
}