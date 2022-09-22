package com.laundry.presentation.category

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.laundry.R
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.domain.Category
import kotlin.coroutines.coroutineContext

class CategoryAdapter(
    private val sharedViewModel: SharedViewModel,
    private val viewLifecycleOwner: LifecycleOwner,
    //private val navController: NavController
): RecyclerView.Adapter<CategoryListHolder>() {

    private var itemList = emptyList<CategoryEntity>()



//    var onItemClick: ((Category) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListHolder {
        return CategoryListHolder(LayoutInflater.from(parent.context).inflate(R.layout.client_home_item,parent,false ))

    }

    override fun onBindViewHolder(holder: CategoryListHolder, position: Int) {



        val categoryItem = itemList[position]

        holder.binding.imageViewPic.setImageResource(categoryItem.image)
        holder.binding.textViewName.text = categoryItem.name
        holder.binding.textViewCount.text = categoryItem.count.toString()

//        holder.binding.rowLayout.setOnClickListener {
//            val action = CategoryFragmentDirections.actionCategoryFragmentToHomeClientFragment(categoryItem)
//
//        }
        countValue(holder,holder.binding.buttonPlus,holder.binding.buttonMinus,holder.binding.textViewCount,holder.binding.checkBox)

        sharedViewModel.amount.observe(viewLifecycleOwner, {
            holder.binding.textViewCount.text.toString()
        })

        holder.binding.saveButton.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_categoryFragment_to_homeClientFragment)
            sharedViewModel.saveItemCount(holder.binding.textViewCount.text.toString())

        }


    }

    private fun countValue(holder: CategoryListHolder, button_plus: View, button_minus: View, countTextView: TextView, checkbox:View){
        var count = 0
        button_plus.setOnClickListener {
            count++
            countTextView.text = count.toString()
            holder.binding.checkBox.isChecked = true
        }
        checkbox.setOnClickListener {
            if(holder.binding.checkBox.isChecked){
                count = 1
                countTextView.text = count.toString()
            }else{
                count = 0
                countTextView.text = count.toString()
            }
        }
        button_minus.setOnClickListener {
            when(count) {
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


//           if( count<=0) count else --count
//            countTextView.text =count.toString()
            }
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