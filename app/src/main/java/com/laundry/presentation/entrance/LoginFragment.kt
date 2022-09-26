package com.laundry.presentation.entrance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.laundry.R
import com.laundry.databinding.FragmentLoginBinding
import com.laundry.domain.entity.LoginRequest
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateToClientHome()
        navigateToServProv() //navigate to Service provider screen

//        binding.loginButton.setOnClickListener {
//            val email = binding.editTextTextEmailAddress.text.toString()
//            val password = binding.editTextTextPassword.text.toString()
//
//            val myPost = LoginRequest(email, password)
//            viewModel.pushLogin(myPost)
//
//            lifecycleScope.launchWhenStarted {
//                viewModel.login.collectLatest {
//                    if (it.pLOGIN_FLAG == "Y") {
//
//                        view.let { it1 ->
//                            Navigation.findNavController(it1).navigate(R.id.action_mainFragment_to_homeClientFragment)
//                        }
//                    } else {
//                        Toast.makeText(
//                            requireContext(),
//                            "INCORRECT EMAIL OR PASSWORD",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            }
//        }


    }

    private fun navigateToClientHome() {
        binding.loginButton.setOnClickListener {

            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            val myPost = LoginRequest(email, password)
            viewModel.pushLogin(myPost)

            lifecycleScope.launchWhenStarted {
                viewModel.login.collectLatest {

                    if (it.pLOGIN_FLAG == "Y") {
                        view.let { it1 ->
                            if (it1 != null) {
                                Navigation.findNavController(it1)
                                    .navigate(R.id.action_mainFragment_to_homeClientFragment)
                            }
                        }
                    }else{
                        Toast.makeText(
                            requireContext(),
                            "INCORRECT EMAIL OR PASSWORD",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }





        }
    }

    private fun navigateToServProv() {

        binding.serviceProviderButton.setOnClickListener {
            view.let { it ->
                if (it != null) {
                    Navigation.findNavController(it)
                        .navigate(R.id.action_mainFragment_to_homeServiceProviderFragment)
                }
            }
        }

    }


    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

}