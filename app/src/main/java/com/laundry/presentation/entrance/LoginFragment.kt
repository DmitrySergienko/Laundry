package com.laundry.presentation.entrance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.laundry.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment: Fragment(){


    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)


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


    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

}