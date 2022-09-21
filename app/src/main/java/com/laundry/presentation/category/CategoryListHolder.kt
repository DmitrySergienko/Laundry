package com.laundry.presentation.category

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.databinding.ClientHomeItemBinding
import com.laundry.domain.Category

class CategoryListHolder(item: View) : RecyclerView.ViewHolder(item) {
    val binding = ClientHomeItemBinding.bind(item)

    fun bind(item: Category) = with(binding) {
        apply {
            imageViewPic.setImageResource(item.image)
            textViewName.text = item.name
            textViewCount.text = item.count.toString()
        }
    }
}