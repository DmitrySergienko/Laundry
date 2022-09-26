package com.laundry.presentation.serviceprovider

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laundry.R
import com.laundry.databinding.FragmentHomeServiceProviderBinding
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeServiceProviderFragment
    : BaseFragment<FragmentHomeServiceProviderBinding>(FragmentHomeServiceProviderBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateToLogin()
    }

    private fun navigateToLogin(){

        binding.imageButtonLogin.setOnClickListener {
            view.let { it ->
                if (it != null) {
                    Navigation.findNavController(it)
                        .navigate(R.id.action_homeServiceProviderFragment_to_mainFragment)
                }
            }
        }

    }

}