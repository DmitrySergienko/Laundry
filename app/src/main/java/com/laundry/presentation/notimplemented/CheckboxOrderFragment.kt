package com.laundry.presentation.notimplemented

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.laundry.databinding.FragmentCheckboxOrderBinding
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckboxOrderFragment
    : BaseFragment<FragmentCheckboxOrderBinding>(FragmentCheckboxOrderBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeContinueButton.setOnClickListener {

            //radio group
            val radioGroupID = binding.radioGroup.checkedRadioButtonId
            val firstRG = view.findViewById<RadioButton>(radioGroupID)

            //checkbox
            val tShirt = binding.checkboxTShirt.isChecked
            val tJacket = binding.checkboxJacket.isChecked
            val tSkirt = binding.checkboxSkirt.isChecked


            val orderString = "Your attach to order:\n" +
                    "${firstRG.text}" +
                    (if (tShirt) "\nT-shirt" else "") +
                    (if (tJacket) "\nJacket" else "") +
                    (if (tSkirt) "\nSkirt" else "")
            binding.textViewOrder.text = orderString
        }
    }
}