package com.laundry.presentation.entrance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laundry.data.remote.api.EntranceApi
import com.laundry.domain.entity.LoginRequest
import com.laundry.domain.entity.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repo: EntranceApi
): ViewModel() {

    private val _login = MutableSharedFlow<LoginResponse>()
    val login = _login.asSharedFlow()

    fun pushLogin(post:LoginRequest){
        viewModelScope.launch {
            val response:LoginResponse = repo.pushLogin(post)

            _login.emit(response)
        }
    }

}