package com.laundry

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.databinding.FragmentCategoryItemBinding
import com.laundry.presentation.BaseFragment
import com.laundry.presentation.category.CategoryViewModel


class CategoryItemFragment :
    BaseFragment<FragmentCategoryItemBinding>(FragmentCategoryItemBinding::inflate) {

    private lateinit var viewModel: CategoryViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submitButton.setOnClickListener {

            viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

            insertDataToDatabase()


        }


    }

    private fun insertDataToDatabase(){
        val category = CategoryEntity(0,false,R.drawable.ic_checkbox_image_one,"Shorts",0)
    //add Data to db
        viewModel.addCategory(category)
        Toast.makeText(requireContext(), "Successfully add category", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_categoryItemFragment_to_categoryFragment)
    }
}