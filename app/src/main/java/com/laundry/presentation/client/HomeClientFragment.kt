package com.laundry.presentation.client

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.navigation.Navigation

import com.laundry.R
import com.laundry.databinding.FragmentCategoryItemBinding
import com.laundry.databinding.FragmentHomeClientBinding
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeClientFragment
    : BaseFragment<FragmentHomeClientBinding>(FragmentHomeClientBinding::inflate) {

    private var increment = 0
   // private val args by navArgs<CategoryItemFragmentArgs>()

    override fun onResume() {
        super.onResume()

        //drop down item adapter
//        val items = resources.getStringArray(R.array.drop_down_home_item)
//        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.drop_down_item_home,items)
//        binding.autoCompleteHomeItem.setAdapter(arrayAdapter)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  binding.textView23.setText(args.currentCategory.count.toString())



        navigateToLogin() // navigate to Login fragment
        navigateToCategory() // navigate to Category fragment
        navigateToDelivery() // navigate to Delivery fragment


//        binding.homeContinueButton.setOnClickListener {
//            if (increment > 0) {
//                view.let { it1 ->
//                    Navigation.findNavController(it1)
//                        .navigate(R.id.action_homeClientFragment_to_deliveryFragment)
//                }
//            } else {
//
//                val toast = Toast.makeText(
//                    requireContext(),
//                    "TO MAKE AN ORDER PLEASE CHOOSE AT LEAST ONE ITEM", Toast.LENGTH_SHORT
//                )
//                toast.setGravity(Gravity.TOP, 500, 0)
//                toast.show()
//
//            }
//
//        }
//        binding.buttonTShirt.setOnClickListener {
//            view.let { it1 ->
//                Navigation.findNavController(it1)
//                    .navigate(R.id.action_homeClientFragment_to_checkboxOrderFragment)
//            }
//        }

    }


    private fun navigateToLogin(){
        binding.homeButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_homeClientFragment_to_mainFragment)
            }
        }
    }



    private fun navigateToCategory(){
        binding.clientHomeCv1.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1).navigate(R.id.action_homeClientFragment_to_categoryFragment)

            }
        }
    }

    private fun navigateToDelivery(){
        binding.categoryButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1).navigate(R.id.action_homeClientFragment_to_deliveryFragment)

            }
        }
    }
}