package com.laundry.presentation.client.sub_category

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.laundry.R
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.databinding.FragmentCategoryBinding
import com.laundry.domain.entity.remote.SubcategoriesItem
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubCategoryFragment :
    BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate) {

    private var adapter: SubCategoryAdapter? = null
    private lateinit var viewModel: SubCategoryViewModel

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        naviagteToHomePage() // navigate to home page

        navigateToHome() // navigate to home

        recyclerView() // initRecyclerView()


        // val total = adapter?.getTotalAmount()
        //save count in shared View Model
        // total?.let { t -> sharedViewModel.saveItemCount(t) }

    }

    private fun naviagteToHomePage() {
        binding.submitButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun recyclerView() {

        //get arguments (subcategory object from home fragment)
        val args: SubCategoryFragmentArgs by navArgs()

        //itemCallback from adapter
        adapter = SubCategoryAdapter() {

        }

        val recyclerView = binding.recyclerCategory
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter?.setData(args.subCategoryArg.subcategories as List<SubcategoriesItem>)

        //viewModel
        //viewModel = ViewModelProvider(this).get(SubCategoryViewModel::class.java)
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

    private fun insertListToDB(list: List<CategoryEntity>) {
        viewModel.insertCategoryList(list)


    }

}