package com.laundry.presentation.serviceprovider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.laundry.R
import com.laundry.domain.entity.local.Service

class ServiceAdapter () : RecyclerView.Adapter<ServiceHolder>() {

        private var itemList = mutableListOf<Service>()


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceHolder {
            return ServiceHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.service_provider_item, parent, false)
            )

        }

        override fun onBindViewHolder(holder: ServiceHolder, position: Int) {

            val categoryItem = itemList[position]
            holder.binding.textViewOrderQuantity.text = categoryItem.orderNumber.toString()
            holder.binding.textViewOrderPrice.text = categoryItem.quantity.toString()
            holder.binding.textViewPriceForOrder.text = categoryItem.price.toString()
            holder.binding.textViewDate.text = categoryItem.data

            navigateToDetails(holder,position)
        }

        private fun navigateToDetails(holder: ServiceHolder, position: Int){
            holder.binding.rootOrderItem.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_homeServiceProviderFragment_to_serviceProviderDetFragment)
            }
        }

        fun setData(item: List<Service>) {
            this.itemList.addAll(item)
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return itemList.size
        }


    }