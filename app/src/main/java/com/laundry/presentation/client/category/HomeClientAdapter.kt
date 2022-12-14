package com.laundry.presentation.client.category


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.laundry.R
import com.laundry.di.BASE_URL
import com.laundry.domain.entity.remote.CategoriesItem
import com.laundry.presentation.client.SharedViewModel

class HomeClientAdapter(
    private val sharedViewModel: SharedViewModel,
    private val viewLifecycleOwner: LifecycleOwner,
    private var onItemClicked: ((CategoriesItem: CategoriesItem) -> Unit) //callback in fragment

) : RecyclerView.Adapter<HomeClientHolder>() {

    private var itemList = mutableListOf<CategoriesItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeClientHolder {
        return HomeClientHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_client_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeClientHolder, position: Int) {
        val categoryItem = itemList[position]

        val url = "$BASE_URL${categoryItem.image}"
        holder.binding.imageViewHome.load(url.replace("public/",""))
        holder.binding.textViewMain.text = categoryItem.text

        //callback to fragment
        holder.binding.rootRowLayout.setOnClickListener {
            onItemClicked(categoryItem)
        }

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
    }

    fun setDataFromApi(category: List<CategoriesItem>) {
        this.itemList.addAll(category)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

//    private fun navigateToSubCategory(holder: HomeClientHolder, position: Int) {
//        holder.binding.rootRowLayout.setOnClickListener {
//
//            //save count in shared View Model
//            val itemPosition = position
//            itemPosition?.let { t -> sharedViewModel.saveMainItem(t) }
//        }
//    }
}
