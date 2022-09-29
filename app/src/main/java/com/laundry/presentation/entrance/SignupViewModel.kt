package com.laundry.presentation.entrance

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.laundry.data.utils.DataState
import com.laundry.domain.entity.remote.Registration
import com.laundry.domain.entity.remote.RegistrationResponse
import com.laundry.domain.usecases.SignUpUsecase
import com.laundry.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val usecase: SignUpUsecase
) : BaseViewModel() {

    private val _signup = MutableSharedFlow<RegistrationResponse>()
    val signup = _signup.asSharedFlow()



    fun pushRegistration(post: Registration) {

        viewModelScope.launch(Dispatchers.IO) {
            usecase.execute(SignUpUsecase.Params(post)).collect { response ->

                when (response) {
                    is DataState.Success -> {
                        Log.d("SignRe", "success")
                        response.value?.let { resp ->
                            _signup.emit(resp)
                        }
                    }
                    is DataState.GenericError -> {

                        response.error?.errorResponse?.let { err ->
                            Log.d("SignRe","error $err")
                            withContext(Dispatchers.Main) {
                                showError.value = "error $err"
                            }
                        }
                    }
                }
            }
        }
    }
}