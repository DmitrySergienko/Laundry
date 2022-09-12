package com.laundry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.laundry.databinding.FragmentDeliveryBinding
import com.laundry.databinding.FragmentLoginBinding
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