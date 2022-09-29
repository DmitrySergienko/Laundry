package com.laundry.presentation.entrance

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.laundry.data.utils.DataState
import com.laundry.domain.entity.remote.LoginRequest
import com.laundry.domain.entity.remote.LoginResponse
import com.laundry.domain.usecases.EntranceUsecase
import com.laundry.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val usecase: EntranceUsecase
) : BaseViewModel() {

    private val _login = MutableSharedFlow<LoginResponse>()
    val login = _login.asSharedFlow()



    fun pushLogin(post: LoginRequest) {

        viewModelScope.launch(Dispatchers.IO) {

            usecase.execute(EntranceUsecase.Params(post)).collect { response ->

                when (response) {
                    is DataState.Success -> {
                        Log.d("loginRe","success")
                        response.value?.let { resp ->
                            _login.emit(resp)
                        }
                    }
                    is DataState.GenericError -> {

                        response.error?.errorResponse?.let { err ->
                            //Log.d("loginRe","error $err")
                            withContext(Dispatchers.Main){
                                showError.value = "INCORRECT EMAIL OR PASSWORD"
                            }
                        }
                    }
                }
            }
        }
    }
}