package com.laundry

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.laundry.databinding.FragmentCategoryBinding
import com.laundry.domain.Category
import com.laundry.presentation.BaseFragment
import com.laundry.presentation.category.CategoryAdapter

class CategoryFragment :
     BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate){

    private val fakeItemList = listOf<Category>(
        Category(R.drawable.ic_checkbox_image_one,"Shorts",3),
        Category(R.drawable.ic_checkbox_image_two,"Cardigan",2),
        Category(R.drawable.ic_checkbox_image_three,"Skirt",3),
        Category(R.drawable.ic_checkbox_image_three,"Skirt",3),
        Category(R.drawable.ic_checkbox_image_three,"Skirt",3),
        Category(R.drawable.ic_checkbox_image_three,"Skirt",3),
        Category(R.drawable.ic_checkbox_image_three,"Skirt",3),
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

    }

    fun initRecyclerView(){
        var todoList = fakeItemList
        val adapter = CategoryAdapter(todoList,requireContext())
        binding.apply {
            recyclerCategory.adapter = adapter
            recyclerCategory.layoutManager = LinearLayoutManager(requireContext())

        }
    }
}