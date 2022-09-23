package com.laundry.presentation.category

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laundry.R
import com.laundry.data.CategoryList
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.utils.DiffUtil
import kotlinx.android.synthetic.main.client_home_item.view.*

class CategoryAdapter : RecyclerView.Adapter<CategoryListHolder>() {

    private var itemList = mutableListOf<CategoryEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListHolder {
        return CategoryListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.client_home_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: CategoryListHolder, position: Int) {

        val categoryItem = itemList[position]
        holder.binding.imageViewPic.setImageResource(categoryItem.image)
        holder.binding.textViewName.text = categoryItem.name
        holder.binding.textViewCount.text = categoryItem.count.toString()
        //holder.binding.checkBox.set = categoryItem.checkbox

        //holder.binding.checkBox.setOnCheckedChangeListener(null)


        holder.binding.checkBox.isChecked = categoryItem.count > 0

        holder.binding.buttonPlus.setOnClickListener {
            categoryItem.count += 1
            notifyItemChanged(position)
        }

//        holder.binding.buttonMinus.setOnClickListener {
//            when (categoryItem.count) {
//                in 1..Int.MAX_VALUE -> {
//                    categoryItem.count -= 1
//                    notifyItemChanged(position)
//                }
//                in 0..1 -> {
//                    holder.binding.checkBox.isChecked = false
//                }
//
//            }
//        }
//        holder.binding.checkBox.setOnClickListener {
//            if (categoryItem.count == 0) {
//                holder.binding.checkBox.isChecked = true
//                categoryItem.count = 1
//            } else {
//                holder.binding.checkBox.isChecked = false
//                categoryItem.count = 0
//            }
//            notifyItemChanged(position)
//        }

    }

    fun getTotalAmount(): Int {
        return itemList.sumOf { it.count }
    }

    private fun countValue(
        holder: CategoryListHolder,
        button_plus: View,
        button_minus: View,
        countTextView: TextView,
        checkbox: View
    ) {
        var count = 0
        button_plus.setOnClickListener {
            count++
            countTextView.text = count.toString()
            holder.binding.checkBox.isChecked = true
        }
        checkbox.setOnClickListener {
            if (holder.binding.checkBox.isChecked) {
                count = 1
                countTextView.text = count.toString()
            } else {
                count = 0
                countTextView.text = count.toString()
            }
        }
        button_minus.setOnClickListener {
            when (count) {
                1 -> {
                    holder.binding.checkBox.isChecked = false
                    count = 0
                    countTextView.text = count.toString()
                }
                in 1..Int.MAX_VALUE -> {
                    count--
                    countTextView.text = count.toString()
                }
                0 -> count

            }
        }
    }

//    fun setData(category: List<CategoryEntity>) {
//        this.itemList.addAll(category)
//        notifyDataSetChanged()
//    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    //diffUtils to update only changed item
    fun setDiffUtilData(newCategoryList: MutableList<CategoryEntity>) {
        val diffUtil = DiffUtil(itemList, newCategoryList)
        val diffResult = androidx.recyclerview.widget.DiffUtil.calculateDiff(diffUtil)
        itemList = newCategoryList
        diffResult.dispatchUpdatesTo(this)
    }


}