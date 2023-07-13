package com.dsm.navibook.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dsm.navibook.model.RecipeModel

@Dao
interface RecipeDAO {
    @Query("SELECT * from Recipe ORDER BY id ASC")
    fun getRecipeList(): LiveData<List<RecipeModel>>

    @Insert
    fun insertRecipe(recipeModel: RecipeModel)

    @Update
    fun updateRecipe(recipeModel: RecipeModel)
}