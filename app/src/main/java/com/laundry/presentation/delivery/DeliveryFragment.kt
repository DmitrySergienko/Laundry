package com.laundry.presentation.delivery

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laundry.R
import com.laundry.databinding.FragmentDeliveryBinding
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeliveryFragment
    : BaseFragment<FragmentDeliveryBinding>(FragmentDeliveryBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            view.let { it1 ->
                Navigation.findNavController(it1).navigate(R.id.action_deliveryFragment_to_homeClientFragment)

            }
        }
    }
}