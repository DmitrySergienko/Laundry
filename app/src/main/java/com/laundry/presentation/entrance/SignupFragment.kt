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
import com.laundry.domain.entity.remote.Registration
import com.laundry.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SignupFragment
    : BaseFragment<FragmentSignupBinding>(FragmentSignupBinding::inflate) {

    private val viewModel: SignupViewModel by viewModels()
    private var serviseCheckbox = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSignup()
        initObservers() // observe error response
        serviceProvCheckbox() // service provider check box activation

    }

    private fun serviceProvCheckbox() {
        binding.checkboxServiceProvider.setOnClickListener {
            when (serviseCheckbox) {
                0 -> {
                    binding.checkboxServiceProvider.isActivated
                    ++ serviseCheckbox
                }
                1 -> { serviseCheckbox = 0 }
            }
        }
    }


private fun initObservers() {
    viewModel.showError.observe(viewLifecycleOwner) {
        Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
    }
}

private fun initSignup() {
    binding.createAccountButton.setOnClickListener {

        val email = binding.edtEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val fullName = binding.etName.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()
        val phone = binding.etPhone.text.toString()


        if (email.isBlank() || password.isBlank() || fullName.isBlank()
            || confirmPassword.isBlank() || phone.isBlank()
        ) {
            Toast.makeText(requireContext(), "PLEASE COMPLETE ALL FIELDS", Toast.LENGTH_SHORT)
                .show()
        } else {
            Toast.makeText(requireContext(), "$serviseCheckbox", Toast.LENGTH_SHORT)
                .show()
            val myPost = Registration(
                fullName,
                email,
                phone,
                password,
                confirmPassword,
                serviseCheckbox.toString()
            )
            viewModel.pushRegistration(myPost)

            lifecycleScope.launchWhenStarted {
                viewModel.signup.collectLatest {
                    when (it.pLOGIN_FLAG) {
                        200 -> {
                            Log.d("VVV", "is success $it")
                            view?.let { it1 ->
                                Navigation.findNavController(it1)
                                    .navigate(R.id.action_mainFragment_to_homeClientFragment)
                            }
                        }

                        else -> {
                            Log.d("VVV", "is not success $it")
                            Toast.makeText(
                                requireContext(),
                                "INCORRECT FILLING ",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }
            }
        }
    }
}

companion object {
    @JvmStatic
    fun newInstance() = SignupFragment()
}

}