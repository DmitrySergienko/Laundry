package com.laundry.presentation.entrance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.laundry.R
import com.laundry.databinding.FragmentMainBinding
import com.laundry.presentation.entrance.viewpager.VpAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val fList = listOf(
        LoginFragment.newInstance(),
        SignupFragment.newInstance()
    )
    private val tList = listOf(
        "LOGIN",
        "SIGNUP"

    )

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() = with(binding){
        val adapter = VpAdapter(activity as FragmentActivity, fList)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager){
                tab, pos -> tab.text = tList[pos]
        }.attach()

    }


    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}