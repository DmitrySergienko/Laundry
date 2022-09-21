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

class CategoryAdapter(
    todo: List<Category>,
    context: Context
): RecyclerView.Adapter<CategoryListHolder>() {

    private val itemList = todo
    private val contextAdapter = context

    var onItemClick: ((Category) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListHolder {
        val view =
            LayoutInflater.from(contextAdapter).inflate(R.layout.client_home_item, parent, false)
        return CategoryListHolder(view)

    }

    override fun onBindViewHolder(holder: CategoryListHolder, position: Int) {
        val category = itemList[position]
        holder.binding.imageViewPic.setImageResource(category.image)
        holder.binding.textViewName.text = category.name
        holder.binding.textViewCount.text = category.count.toString()

        holder.bind(itemList[position])

        //set call back for item click
        holder.binding.buttonPlus.setOnClickListener {
            onItemClick?.invoke(category)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }



}