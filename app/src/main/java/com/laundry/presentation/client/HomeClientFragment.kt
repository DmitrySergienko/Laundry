package com.laundry.presentation.client

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.laundry.R
import com.laundry.databinding.FragmentHomeClientBinding
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeClientFragment
    : BaseFragment<FragmentHomeClientBinding>(FragmentHomeClientBinding::inflate) {

    private var increment = 0

    override fun onResume() {
        super.onResume()

        //drop down item adapter
//        val items = resources.getStringArray(R.array.drop_down_home_item)
//        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.drop_down_item_home,items)
//        binding.autoCompleteHomeItem.setAdapter(arrayAdapter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //fake item calculation
        with(binding) {
            itemCount(buttonPlus, buttonMinus, textView12)
            itemCount(buttonPlus2, buttonMinus2, textView122)
            itemCount(buttonPlus3, buttonMinus3, textView123)


        }

        binding.homeButton.setOnClickListener {
            view.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_homeClientFragment_to_mainFragment)
            }
        }
        binding.homeContinueButton.setOnClickListener {
            if (increment > 0) {
                view.let { it1 ->
                    Navigation.findNavController(it1)
                        .navigate(R.id.action_homeClientFragment_to_deliveryFragment)
                }
            } else {

                val toast = Toast.makeText(
                    requireContext(),
                    "TO MAKE AN ORDER PLEASE CHOOSE AT LEAST ONE ITEM", Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.TOP, 500, 0)
                toast.show()

            }

        }
        binding.buttonTShirt.setOnClickListener {
            view.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_homeClientFragment_to_checkboxOrderFragment)
            }
        }

    }

    private fun itemCount(button_plus: View, button_minus: View, text: TextView) {

        button_plus.setOnClickListener {
            increment++
            text.text = increment.toString()
        }
        button_minus.setOnClickListener {
            if (increment <= 0) increment else increment--
            text.text = increment.toString()
        }
    }
}