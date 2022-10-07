package com.laundry.presentation.client.sub_category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.laundry.R
import com.laundry.di.BASE_URL
import com.laundry.domain.entity.remote.SubcategoriesItem

class SubCategoryAdapter(

    private var onItemClicked: ((CategoriesItem: SubcategoriesItem) -> Unit) //callback in fragment
) : RecyclerView.Adapter<SubCategoryListHolder>() {

    private var itemList = mutableListOf<SubcategoriesItem>()

    var activation = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryListHolder {
        return SubCategoryListHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.client_category_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: SubCategoryListHolder, position: Int) {

        val categoryItem = itemList[position]

        val url = "$BASE_URL${categoryItem.image}"

        holder.binding.imageViewPic.load(url.replace("public/", ""))
        holder.binding.textViewName.text = categoryItem.text
        holder.binding.textViewCount.text = categoryItem.count.toString()
        holder.binding.checkBox.isChecked = activation

        holder.binding.buttonPlus.setOnClickListener {
            categoryItem.count += 1
            notifyItemChanged(position)
            activation = true
        }
        holder.binding.buttonMinus.setOnClickListener {
            when (categoryItem.count) {
                0 -> {
                    categoryItem.count = 0
                    notifyItemChanged(position)
                }
                1 -> {
                    categoryItem.count -= 1
                    notifyItemChanged(position)
                    activation = false
                }
                in 1..Int.MAX_VALUE -> {
                    categoryItem.count -= 1
                    notifyItemChanged(position)
                }

                else -> activation = false
            }
        }
        holder.binding.checkBox.setOnClickListener {
            when (categoryItem.count) {
                0 -> {
                    categoryItem.count += 1
                    holder.binding.textViewCount.text = "1"
                    holder.binding.checkBox.isChecked
                }
                else -> {
                    holder.binding.textViewCount.text = "0"
                    categoryItem.count = 0
                    holder.binding.checkBox.isChecked = false
                }
            }
        }


        //callback to fragment
        holder.binding.rootSubCategory.setOnClickListener {
            onItemClicked(categoryItem)
        }
    }


//    fun getTotalAmount(): Int {
//        return itemList.sumOf { it.count }
//    }


    fun setData(category: List<SubcategoriesItem>) {
        this.itemList.addAll(category)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}