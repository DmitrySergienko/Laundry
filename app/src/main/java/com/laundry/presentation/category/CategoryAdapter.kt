package com.laundry.presentation.category

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.laundry.R
import com.laundry.data.database.entities.CategoryEntity

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

        //calculate how many items chosen and setText in TextView
        //  countValue(holder,holder.binding.buttonPlus,holder.binding.buttonMinus,holder.binding.textViewCount,holder.binding.checkBox)

//        holder.binding.saveButton.setOnClickListener {view ->
//           //view.findNavController().navigate(R.id.action_categoryFragment_to_homeClientFragment)
//            val sum = holder.binding.textViewCount.text.toString()
//
//            Log.d("VVV", sum)
//
//            //save count in shared viewModel
//            sharedViewModel.saveItemCount(sum)
//
//
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

    fun setData(category: List<CategoryEntity>) {
        this.itemList.addAll(category)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}