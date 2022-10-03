package com.laundry.presentation.client.sub_category

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.laundry.R
import com.laundry.data.CategoryList
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.databinding.FragmentCategoryBinding
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment :
    BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate) {

    private var adapter: CategoryAdapter? = null
    private val fakeItemList = CategoryList()
    private lateinit var viewModel: CategoryViewModel

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView() // initRecyclerView()
        navigateToHome() // navigate to home

       //insertListToDB(fakeItemList.list)
       // cleanDataFromDB()


        binding.submitButton.setOnClickListener {
            val total = adapter?.getTotalAmount()
            //save count in shared View Model
            total?.let { t -> sharedViewModel.saveItemCount(t) }

            findNavController().navigateUp() // navigate to home page
        }
    }

    private fun recyclerView() {

        //recyclerView
        adapter = CategoryAdapter()
        val recyclerView = binding.recyclerCategory
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //viewModel
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        viewModel.readAllData.observe(viewLifecycleOwner, Observer { category ->
            adapter?.setData(category as MutableList<CategoryEntity>)

        })
    }

    private fun navigateToHome() {
        binding.backButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_categoryFragment_to_homeClientFragment)
            }
        }
    }

    private fun cleanDataFromDB() {
        viewModel.cleanCategoryList()
        Toast.makeText(
            requireContext(),
            "The Category List was cleanup successfully",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun insertListToDB(list: List<CategoryEntity>){
        viewModel.insertCategoryList(list)


    }

}