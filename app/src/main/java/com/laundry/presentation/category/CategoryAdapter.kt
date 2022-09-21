package com.laundry.presentation.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laundry.R
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.databinding.ClientHomeItemBinding
import com.laundry.domain.Category

class CategoryAdapter(): RecyclerView.Adapter<CategoryListHolder>() {

    private var itemList = emptyList<CategoryEntity>()

    var onItemClick: ((Category) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListHolder {
        return CategoryListHolder(LayoutInflater.from(parent.context).inflate(R.layout.client_home_item,parent,false ))

    }

    override fun onBindViewHolder(holder: CategoryListHolder, position: Int) {
        val category = itemList[position]
        holder.binding.imageViewPic.setImageResource(category.image)
        holder.binding.textViewName.text = category.name
        holder.binding.textViewCount.text = category.count.toString()

    }
    fun setData(category: List<CategoryEntity>){
        this.itemList = category
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}