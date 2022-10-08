package com.laundry.presentation.client.sub_category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laundry.R
import com.laundry.data.database.entities.CategoryEntity

class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryListHolder>() {

    private var itemList = mutableListOf<CategoryEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryListHolder {
        return SubCategoryListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.client_category_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: SubCategoryListHolder, position: Int) {

        val categoryItem = itemList[position]
        holder.binding.imageViewPic.setImageResource(categoryItem.image)
        holder.binding.textViewName.text = categoryItem.name
        holder.binding.textViewCount.text = categoryItem.count.toString()
        holder.binding.checkBox.isChecked = categoryItem.count >0

        holder.binding.buttonPlus.setOnClickListener {
            categoryItem.count += 1
            notifyItemChanged(position)
        }
        holder.binding.buttonMinus.setOnClickListener {
            if (categoryItem.count > 0) {
                categoryItem.count -= 1
                notifyItemChanged(position)
            }
        }
        holder.binding.checkBox.setOnClickListener {
            when(categoryItem.count){
                0 -> {
                    categoryItem.count += 1
                    holder.binding.textViewCount.text = "1"
                }
                else -> {
                    holder.binding.textViewCount.text = "0"
                    categoryItem.count = 0
                }
            }
        }
    }


    fun getTotalAmount(): Int {
        return itemList.sumOf { it.count }
    }


    fun setData(category: List<CategoryEntity>) {
        this.itemList.addAll(category)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}