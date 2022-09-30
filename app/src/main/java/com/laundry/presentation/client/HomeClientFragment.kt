package com.laundry.presentation.client

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.laundry.R
import com.laundry.data.ClientHome
import com.laundry.data.repository.datastore.DataStoreViewModel
import com.laundry.databinding.FragmentHomeClientBinding
import com.laundry.presentation.BaseFragment
import com.laundry.presentation.category.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeClientFragment
    : BaseFragment<FragmentHomeClientBinding>(FragmentHomeClientBinding::inflate) {

    private var adapter: HomeClientAdapter? = null
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val fakeList = ClientHome()


    private lateinit var dataStoreViewModel: DataStoreViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView() // initRecyclerView()

        navigateToLogin() // navigate to Login fragment

        navigateToDelivery() // navigate to Delivery fragment

        showClientName() //save Client Name in DataStore and show in the field

    }

    private fun showClientName(){
        dataStoreViewModel = ViewModelProvider(this).get(DataStoreViewModel::class.java)
        dataStoreViewModel.readFromDataStore.observe(viewLifecycleOwner,{myName->
            binding.textViewClientName.text = myName
        })

    }

    private fun recyclerView() {

        adapter = HomeClientAdapter(sharedViewModel,viewLifecycleOwner)
        val recyclerView = binding.recyclerCategoryHome
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

            adapter?.setData(fakeList.list)

    }

    private fun navigateToLogin() {
        binding.homeButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_homeClientFragment_to_mainFragment)
            }
        }
    }

    private fun navigateToDelivery() {
        binding.completeOrderButton.setOnClickListener {
            sharedViewModel.amount.observe(viewLifecycleOwner) { amount ->
                if (amount > 0) {
                    view.let { it1 ->
                        if (it1 != null) {
                            Navigation.findNavController(it1)
                                .navigate(R.id.action_homeClientFragment_to_deliveryFragment)
                        }
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "TO MAKE AN ORDER PLEASE CHOOSE AT LEAST ONE ITEM",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }


}