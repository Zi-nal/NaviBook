package com.dsm.navibook.view

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dsm.navibook.RecyclerViewAdapter
import com.dsm.navibook.databinding.ActivityMainBinding
import com.dsm.navibook.viewmodel.RecipeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: RecyclerViewAdapter
    private lateinit var mViewModel: RecipeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()
        initAddButton()
        mAdapter.itemClickListener = object : RecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, RecipeActivity::class.java)
                intent.putExtra("id", mAdapter.recipeList[position].id)
                intent.putExtra("title", mAdapter.recipeList[position].title)
                intent.putExtra("time", mAdapter.recipeList[position].time)
                intent.putExtra("type", mAdapter.recipeList[position].type)
                intent.putExtra("ingredient", mAdapter.recipeList[position].ingredient)
                intent.putExtra("condiment", mAdapter.recipeList[position].condiment)
                intent.putExtra("content", mAdapter.recipeList[position].content)
                startActivity(intent)
            }
        }
    }

    private fun initRecyclerView() {
        mAdapter = RecyclerViewAdapter()

        binding.recyclerView.run {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = mAdapter
        }
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(RecipeViewModel::class.java)
        mViewModel.getRecipeList().observe(this, Observer { mAdapter.setRecipeItems(it) })
    }

    private fun initAddButton() {
        binding.add.setOnClickListener {
            startActivity(Intent(this, RecipeCreateActivity::class.java))
        }
    }
}
