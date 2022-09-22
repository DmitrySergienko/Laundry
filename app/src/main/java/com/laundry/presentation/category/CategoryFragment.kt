package com.laundry.presentation.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.laundry.R
import com.laundry.data.CategoryList
import com.laundry.databinding.FragmentCategoryBinding
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment :
    BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate) {

    private val fakeItemList = CategoryList()
    private lateinit var viewModel: CategoryViewModel

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // initRecyclerView()
        recyclerView()
        navigateToHome() // navigate to home



    }

    private fun recyclerView(){

        //recyclerView
        val adapter = CategoryAdapter(sharedViewModel, viewLifecycleOwner = viewLifecycleOwner)
        val recyclerView = binding.recyclerCategory
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //viewModel
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {category ->
            adapter.setData(category)
        })
    }

    private fun initRecyclerView() {
        //val db = CategoryDatabase.getDb(this)
//        val db = CategoryDatabase.getDb(requireContext())
//        val dao = db.getCategoryDao()
//
//        Executors.newSingleThreadExecutor().execute {
//            dao.deleteAll()
//            dao.insertCategory(fakeItemList.list)
//
//            //val result = dao.getAll()
//            val list = mutableListOf<Category>()

            // add to list from db
//            for (i in result) list.add(
//                Category(
//                    i.id,
//                    checkbox = i.checkbox,
//                    image = i.image,
//                    name = i.name,
//                    i.count
//                )
//            )

//            val recyclerList = list
//            val adapter = CategoryAdapter(recyclerList, requireContext())

//            binding.recyclerCategory.adapter = adapter
//            binding.recyclerCategory.layoutManager = LinearLayoutManager(requireContext())
//
//            adapter.onItemClick = {
//                Toast.makeText(requireContext(), "${it.count}", Toast.LENGTH_SHORT).show()
//            }
//        }
    }

    private fun navigateToHome() {
        binding.backButton.setOnClickListener {
            view?.let { it1 ->
                Navigation.findNavController(it1)
                    .navigate(R.id.action_categoryFragment_to_homeClientFragment)
            }
        }
    }


}