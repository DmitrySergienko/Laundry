package com.laundry.presentation.client.category

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.laundry.R
import com.laundry.data.repository.datastore.DataStoreViewModel
import com.laundry.databinding.FragmentHomeClientBinding
import com.laundry.domain.entity.remote.CategoriesItem
import com.laundry.domain.entity.remote.SaveOrder
import com.laundry.presentation.BaseFragment
import com.laundry.presentation.client.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class HomeClientFragment
    : BaseFragment<FragmentHomeClientBinding>(FragmentHomeClientBinding::inflate) {

    private var adapter: HomeClientAdapter? = null
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: HomeClientViewModel by viewModels()
    private lateinit var dataStoreViewModel: DataStoreViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView() // initRecyclerView()

        navigateToLogin() // navigate to Login fragment

        navigateToDelivery() // navigate to Delivery fragment

        showClientName() //save Client Name in DataStore and show in the field


        //Order history test
        viewModel.getOrderHistory()
        lifecycleScope.launchWhenStarted {
            viewModel.orderHistory.collectLatest {

                Log.d("TestLog", it.orderHistoryResponse.toString())

            }
        }

        //save order test
        val myPost =SaveOrder()
        viewModel.getSaveOrder(myPost)
        lifecycleScope.launchWhenStarted {
            viewModel.saveOrder.collectLatest {

                Log.d("TestLog", it.saveOrderResponse.toString())

            }
        }
    }

    private fun showClientName() {
        //read client name from Store ViewModel
        dataStoreViewModel = ViewModelProvider(this).get(DataStoreViewModel::class.java)
        dataStoreViewModel.readFromDataStore.observe(viewLifecycleOwner, { myName ->
            binding.textViewClientName.text = myName
        })
    }

    private fun recyclerView() {
        viewModel.getCategory()

        //callback from adapter, pass object to sub_category
        adapter = HomeClientAdapter(sharedViewModel,viewLifecycleOwner) {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(
                        HomeClientFragmentDirections.actionHomeClientFragmentToCategoryFragment(
                            it
                        )
                    )
            }
        }

        val recyclerView = binding.recyclerCategoryHome
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //get list from viewModel
        lifecycleScope.launchWhenStarted {
            viewModel.category.collectLatest {

                if (it.LOGIN_FLAG == 200) {
                    view.let { it1 ->
                        val categoryList = it.DATA?.categories
                        adapter?.setDataFromApi(categoryList as List<CategoriesItem>)
                    }
                } else {
                    Toast.makeText(
                        requireContext(), "INCORRECT CATEGORY REQUEST", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
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