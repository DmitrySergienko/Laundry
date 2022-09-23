package com.laundry.utils

import androidx.recyclerview.widget.DiffUtil
import com.laundry.data.database.entities.CategoryEntity


class DiffUtil(
    private val oldList: List<CategoryEntity>,
    private val newList: List<CategoryEntity>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {

            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                false
            }
            oldList[oldItemPosition].checkbox != newList[newItemPosition].checkbox -> {
                false
            }
            oldList[oldItemPosition].name != newList[newItemPosition].name -> {
                false
            }
            oldList[oldItemPosition].count != newList[newItemPosition].count -> {
                false
            }
            else -> true

        }
    }
}