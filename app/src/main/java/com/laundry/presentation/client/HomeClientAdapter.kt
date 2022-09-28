package com.laundry.presentation.client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.laundry.R
import com.laundry.domain.entity.local.HomeClient
import com.laundry.presentation.category.SharedViewModel

class HomeClientAdapter(
    private val sharedViewModel: SharedViewModel,
    private val viewLifecycleOwner: LifecycleOwner

) : RecyclerView.Adapter<HomeClientHolder>() {

    private var itemList = mutableListOf<HomeClient>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeClientHolder {
        return HomeClientHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_client_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: HomeClientHolder, position: Int) {

        val categoryItem = itemList[position]
        holder.binding.imageViewHome.setImageResource(categoryItem.image)
        holder.binding.textViewMain.text = categoryItem.name
        holder.binding.textViewQuantity.text = categoryItem.quantity.toString()

        //get count of click from share view model
        sharedViewModel.amount.observe(viewLifecycleOwner) { amount ->

            if (amount == 0) {
                holder.binding.cardViewOrder.visibility = View.INVISIBLE
                holder.binding.textViewMain.visibility = View.VISIBLE
            } else {
                holder.binding.textViewQuantity.setText(amount.toString())

                val result = amount * 100
                holder.binding.textViewPrice.text = result.toString()
            }

        }

        navigateToSubCategory(holder,position)


    }
    private fun navigateToSubCategory(holder: HomeClientHolder, position: Int){
        holder.binding.rootRowLayout.setOnClickListener {

            Navigation.findNavController(it)
                .navigate(R.id.action_homeClientFragment_to_categoryFragment)

            //save count in shared View Model
            val itemPosition = position
            itemPosition?.let { t -> sharedViewModel.saveMainItem(t) }

        }
    }


//        fun getTotalAmount(): Int {
//            return itemList.sumOf { it.count }
//        }


    fun setData(category: List<HomeClient>) {
        this.itemList.addAll(category)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}
