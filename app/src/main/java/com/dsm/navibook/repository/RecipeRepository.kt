package com.dsm.navibook.repository

import android.app.Application
import android.database.Observable
import androidx.lifecycle.LiveData
import com.dsm.navibook.database.RecipeDAO
import com.dsm.navibook.database.RecipeDatabase
import com.dsm.navibook.model.RecipeModel

class RecipeRepository(application: Application) {
    private var mRecipeDatabase: RecipeDatabase
    private var mRecipeDAO: RecipeDAO
    private var mRecipeItems: LiveData<List<RecipeModel>>

    init {
        mRecipeDatabase = RecipeDatabase.getInstance(application)
        mRecipeDAO = mRecipeDatabase.recipeDao()
        mRecipeItems = mRecipeDAO.getRecipeList()
    }

    fun getRecipeList(): LiveData<List<RecipeModel>> {
        return mRecipeItems
    }

    fun insertRecipe(recipeModel: RecipeModel) {
        Thread(Runnable {
            mRecipeDAO.insertRecipe(recipeModel)
        }).start()
    }

    fun updateRecipe(recipeModel: RecipeModel) {
        Thread(Runnable {
            mRecipeDAO.updateRecipe(recipeModel)
        }).start()
    }
}