package com.laundry.presentation.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laundry.R
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.domain.Category

class CategoryAdapter(): RecyclerView.Adapter<CategoryListHolder>() {

    private var itemList = emptyList<CategoryEntity>()

//    var onItemClick: ((Category) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListHolder {
        return CategoryListHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_category_item,parent,false ))

    }

    override fun onBindViewHolder(holder: CategoryListHolder, position: Int) {

        val categoryItem = itemList[position]

        holder.binding.imageViewPic.setImageResource(categoryItem.image)
        holder.binding.textViewName.text = categoryItem.name
        holder.binding.textViewCount.text = categoryItem.count.toString()

        holder.binding.rowLayout.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToHomeClientFragment(categoryItem)

        }
    }

    fun setData(category: List<CategoryEntity>){
        this.itemList = category
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}