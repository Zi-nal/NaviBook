package com.dsm.navibook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dsm.navibook.model.RecipeModel
import com.dsm.navibook.databinding.ItemListBinding

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    var recipeList: List<RecipeModel> = listOf()

    interface OnItemClickListener {
        fun onItemClick(position: Int) {}
    }

    var itemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = recipeList.size


    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(recipeList[position])
    }

    inner class RecyclerViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipeList: RecipeModel) {
            binding.title.text = recipeList.title
            binding.time.text = recipeList.time
            binding.type.text = recipeList.type
        }

        init {
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(adapterPosition)
            }
        }
    }

    fun setRecipeItems(recipeList: List<RecipeModel>) {
        this.recipeList = recipeList
        notifyDataSetChanged()
    }
}
