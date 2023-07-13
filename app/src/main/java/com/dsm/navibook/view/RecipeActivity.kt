package com.dsm.navibook.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dsm.navibook.R
import com.dsm.navibook.databinding.ActivityRecipeBinding

class RecipeActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        val id = intent.getLongExtra("id", 0)
        val title = intent.getStringExtra("title")
        val time = intent.getStringExtra("time")
        val type = intent.getStringExtra("type")
        val ingredient = intent.getStringExtra("ingredient")
        val condiment = intent.getStringExtra("condiment")
        val content = intent.getStringExtra("content")
        binding.title2.text = title
        binding.title.text = title
        binding.time.text = time
        binding.type.text = type
        binding.ingredient.text = ingredient
        binding.condiment.text = condiment
        binding.content.text = content
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        binding.menuBtn.setOnClickListener {
            val intent = Intent(this, RecipeUpdateActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("title", title)
            intent.putExtra("time", time)
            intent.putExtra("type", type)
            intent.putExtra("ingredient", ingredient)
            intent.putExtra("condiment", condiment)
            intent.putExtra("content", content)
            startActivity(intent)
        }
    }
}