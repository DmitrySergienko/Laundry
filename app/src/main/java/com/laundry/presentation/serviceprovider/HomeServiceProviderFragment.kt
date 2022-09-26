package com.laundry.presentation.serviceprovider

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.laundry.R
import com.laundry.data.ServiceOrder
import com.laundry.databinding.FragmentHomeServiceProviderBinding
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeServiceProviderFragment
    : BaseFragment<FragmentHomeServiceProviderBinding>(FragmentHomeServiceProviderBinding::inflate) {

    private val fakeList = ServiceOrder()
    private var adapter: ServiceAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateToLogin()

        recyclerView()

    }

    private fun recyclerView() {
        adapter = ServiceAdapter()
        val recyclerView = binding.recyclerServiceProvider
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter?.setData(fakeList.list)

    }

    private fun navigateToLogin(){

        binding.imageButtonLogin.setOnClickListener {
            view.let { it ->
                if (it != null) {
                    Navigation.findNavController(it)
                        .navigate(R.id.action_homeServiceProviderFragment_to_mainFragment)
                }
            }
        }

    }

}