package com.laundry.presentation.category

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.laundry.R
import com.laundry.data.CategoryList
import com.laundry.databinding.FragmentCategoryBinding
import com.laundry.presentation.BaseFragment

class CategoryFragment :
     BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate){

    private val fakeItemList = CategoryList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        navigateToHome() // navigate to home

    }

    private fun initRecyclerView(){
        var todoList = fakeItemList.fakeItemList
        val adapter = CategoryAdapter(todoList,requireContext())
        binding.apply {
            recyclerCategory.adapter = adapter
            recyclerCategory.layoutManager = LinearLayoutManager(requireContext())

        }
    }

    private fun navigateToHome(){
        binding.backButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_categoryFragment_to_homeClientFragment)
            }
        }
    }



}