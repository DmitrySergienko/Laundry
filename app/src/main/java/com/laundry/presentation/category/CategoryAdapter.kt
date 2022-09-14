package com.laundry.presentation.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laundry.R
import com.laundry.databinding.ClientHomeItemBinding
import com.laundry.domain.Category

class CategoryAdapter(
    todo: List<Category>,
    context: Context
): RecyclerView.Adapter<CategoryAdapter.CategoryListHolder>() {

    private val workoutItemList = todo
    private val contextAdapter = context


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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListHolder {
        val view =
            LayoutInflater.from(contextAdapter).inflate(R.layout.client_home_item, parent, false)
        return CategoryListHolder(view)

    }

    override fun onBindViewHolder(holder: CategoryListHolder, position: Int) {
        holder.bind(workoutItemList[position])
    }

    override fun getItemCount(): Int {
        return workoutItemList.size
    }



}