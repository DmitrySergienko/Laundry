package com.laundry.presentation.client

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.laundry.R
import com.laundry.databinding.FragmentHomeClientBinding
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeClientFragment
    : BaseFragment<FragmentHomeClientBinding>(FragmentHomeClientBinding::inflate) {

    private var increment = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonPlus.setOnClickListener {
            increment++
            binding.textView12.text =increment.toString()
        }
        binding.buttonMinus.setOnClickListener {
            increment--
            binding.textView12.text =increment.toString()
        }

        binding.imageView2.setOnClickListener {
            view.let { it1 ->
                Navigation.findNavController(it1).navigate(R.id.action_homeClientFragment_to_mainFragment)
            }
        }
        binding.homeContinueButton.setOnClickListener {
            view.let { it1 ->
                Navigation.findNavController(it1).navigate(R.id.action_homeClientFragment_to_deliveryFragment)
            }
        }
    }
}