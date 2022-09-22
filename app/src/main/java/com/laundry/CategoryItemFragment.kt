package com.laundry

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.databinding.FragmentCategoryItemBinding
import com.laundry.presentation.BaseFragment
import com.laundry.presentation.category.CategoryViewModel
import com.laundry.presentation.category.SharedViewModel


class CategoryItemFragment :
    BaseFragment<FragmentCategoryItemBinding>(FragmentCategoryItemBinding::inflate) {

    private lateinit var viewModel: CategoryViewModel
    private var count = 0



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonMinus.setOnClickListener {

            viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

            insertDataToDatabase()
            increment()



        }
    }

    private fun insertDataToDatabase(){
        val category = CategoryEntity(0,false,R.drawable.ic_checkbox_image_two,"Shorts",0)
    //add Data to db
        viewModel.addCategory(category)
        Toast.makeText(requireContext(), "Successfully add category", Toast.LENGTH_SHORT).show()
       // findNavController().navigate(R.id.action_categoryItemFragment_to_categoryFragment)
    }

    private fun increment(){
        binding.buttonPlus.setOnClickListener {
            count++
            binding.textViewCount.text = count.toString()
        }
    }
}