package com.laundry.presentation.entrance

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.laundry.R
import com.laundry.databinding.FragmentSignupBinding
import com.laundry.domain.entity.Registration
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SignupFragment
    :BaseFragment<FragmentSignupBinding>(FragmentSignupBinding::inflate){

    private val viewModel:SignupViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //back button
        binding.backButton.setOnClickListener { it1->
            Navigation.findNavController(it1).navigate(R.id.action_signupFragment_to_loginFragment)
        }

        //enter button
        binding.enterButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val firstName = binding.firstNameEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()

            if (email.isBlank() || password.isBlank() || lastName.isBlank()
                || firstName.isBlank() || phone.isBlank()
            ) {
                Toast.makeText(requireContext(), "PLEASE COMPLETE ALL FIELDS", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val myPost = Registration(email, password, lastName, phone, firstName)
                viewModel.pushRegistration(myPost)

                lifecycleScope.launchWhenStarted {
                    viewModel.signup.collectLatest {
                        if (it.isSuccessful) {

                            view.let { it1 ->
                                Navigation.findNavController(it1)
                                    .navigate(R.id.action_signupFragment_to_loginFragment)
                            }

                        } else {
                            Log.d("VVV", it.body().toString())
                        }
                    }
                }
            }
        }


    }

}