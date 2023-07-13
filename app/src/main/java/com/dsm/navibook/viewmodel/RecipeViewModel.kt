package com.dsm.navibook.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dsm.navibook.model.RecipeModel
import com.dsm.navibook.repository.RecipeRepository

class RecipeViewModel(application: Application) : AndroidViewModel(application) {
    private val mRecipeRepository: RecipeRepository
    private val mRecipeItem: LiveData<List<RecipeModel>>

    init {
        mRecipeRepository = RecipeRepository(application)
        mRecipeItem = mRecipeRepository.getRecipeList()
    }

    fun insertRecipe(recipeModel: RecipeModel) {
        mRecipeRepository.insertRecipe(recipeModel)
    }

    fun getRecipeList(): LiveData<List<RecipeModel>> {
        return mRecipeItem
    }

    fun updateRecipe(recipeModel: RecipeModel) {
        mRecipeRepository.updateRecipe(recipeModel)
    }

}