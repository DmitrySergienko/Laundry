package com.laundry.presentation.entrance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laundry.data.remote.api.EntranceApi
import com.laundry.domain.entity.Registration
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val repo: EntranceApi
) : ViewModel() {

    private val _signup = MutableSharedFlow<Response<Void>>()
    val signup = _signup.asSharedFlow()

    fun pushRegistration(post: Registration) {
        viewModelScope.launch {
            val response: Response<Void> = repo.pushRegistration(post)

            _signup.emit(response)
        }
    }

}