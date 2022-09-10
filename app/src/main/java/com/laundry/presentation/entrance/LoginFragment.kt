package com.laundry.presentation.entrance

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.laundry.R
import com.laundry.databinding.FragmentLoginBinding
import com.laundry.domain.entity.LoginRequest
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class LoginFragment
    : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //go to signup screen
//        binding.serviceProviderButton.setOnClickListener { it1 ->
//
//            Navigation.findNavController(it1)
//                .navigate(R.id.action_loginFragment_to_signupFragment)
//
//        }

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
//                            Navigation.findNavController(it1)
//                                .navigate(R.id.action_loginFragment_to_homeClientFragment)
//
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

}