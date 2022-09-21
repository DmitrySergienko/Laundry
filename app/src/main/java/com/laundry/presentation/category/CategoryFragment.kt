package com.laundry.presentation.category

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.laundry.R
import com.laundry.data.CategoryList
import com.laundry.data.database.CategoryDatabase
import com.laundry.databinding.FragmentCategoryBinding
import com.laundry.domain.Category
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import java.util.concurrent.Executors

@AndroidEntryPoint
class CategoryFragment :
    BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate) {

    private val fakeItemList = CategoryList()
    //private val viewModel: CategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        navigateToHome() // navigate to home

    }

    private fun initRecyclerView() {
        //val db = CategoryDatabase.getDb(this)
        val db = CategoryDatabase.getDb(requireContext())
        val dao = db.getCategoryDao()

        Executors.newSingleThreadExecutor().execute {

//            dao.deleteAll()
//            dao.insertCategory(fakeItemList.list)

            val result = dao.getAll()
            val list = mutableListOf<Category>()

            // add to list from db
            for (i in result) list.add(
                Category(
                    i.id,
                    checkbox = i.checkbox,
                    image = i.image,
                    name = i.name,
                    i.count
                )
            )

            val recyclerList = list
            val adapter = CategoryAdapter(recyclerList, requireContext())

            binding.recyclerCategory.adapter = adapter
            binding.recyclerCategory.layoutManager = LinearLayoutManager(requireContext())

            adapter.onItemClick = {
                Toast.makeText(requireContext(), "${it.count}", Toast.LENGTH_SHORT).show()
            }
        }
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