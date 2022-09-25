package com.laundry.presentation.client

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.laundry.R
import com.laundry.databinding.FragmentHomeClientBinding
import com.laundry.presentation.BaseFragment
import com.laundry.presentation.category.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeClientFragment
    : BaseFragment<FragmentHomeClientBinding>(FragmentHomeClientBinding::inflate) {


    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        navigateToLogin() // navigate to Login fragment
        navigateToCategory() // navigate to Category fragment
        navigateToDelivery() // navigate to Delivery fragment

        //get count of click from share view model
        sharedViewModel.amount.observe(viewLifecycleOwner) { amount ->

            if (amount == 0) {
                binding.cardViewPrice.visibility = View.INVISIBLE
                binding.textView9.visibility = View.VISIBLE
            } else {
                binding.textView23.setText(amount.toString())

                val result = amount * 100
                binding.textView26.text = result.toString()
            }

        }


        binding.completeOrderButton.setOnClickListener {
            sharedViewModel.amount.observe(viewLifecycleOwner) { amount ->
                if (amount > 0) {
                    view.let { it1 ->
                        Navigation.findNavController(it1)
                            .navigate(R.id.action_homeClientFragment_to_deliveryFragment)
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


    private fun navigateToLogin() {
        binding.homeButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_homeClientFragment_to_mainFragment)
            }
        }
    }

    private fun navigateToCategory() {

        binding.clientHomeCv1.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_homeClientFragment_to_categoryFragment)

            }
        }
    }


    private fun navigateToDelivery() {
        binding.completeOrderButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_homeClientFragment_to_deliveryFragment)

            }
        }
    }
}