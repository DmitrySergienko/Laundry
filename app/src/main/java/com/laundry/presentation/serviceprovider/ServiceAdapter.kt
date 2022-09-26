package com.laundry.presentation.serviceprovider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laundry.R
import com.laundry.domain.Service

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


        }


        fun setData(item: List<Service>) {
            this.itemList.addAll(item)
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {
            return itemList.size
        }


    }