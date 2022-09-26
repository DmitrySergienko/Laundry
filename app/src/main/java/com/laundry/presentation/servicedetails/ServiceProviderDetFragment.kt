package com.laundry.presentation.servicedetails

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laundry.R
import com.laundry.databinding.FragmentServiceProviderDetBinding
import com.laundry.presentation.BaseFragment


class ServiceProviderDetFragment
    : BaseFragment<FragmentServiceProviderDetBinding>(FragmentServiceProviderDetBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateToServiceOrderList()
    }

    private fun navigateToServiceOrderList() {
        binding.backButton.setOnClickListener {
            view?.let { it ->
                Navigation.findNavController(it)
                    .navigate(R.id.action_serviceProviderDetFragment_to_homeServiceProviderFragment)
            }
        }
    }
}