package com.laundry.presentation.client.category

import androidx.lifecycle.viewModelScope
import com.laundry.data.utils.DataState
import com.laundry.domain.entity.remote.CategoryResponse
import com.laundry.domain.usecases.CategoryUseCase
import com.laundry.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeClientViewModel @Inject constructor(
    private val usecase: CategoryUseCase
) : BaseViewModel() {

    private val _category = MutableSharedFlow<CategoryResponse>()
    val category = _category.asSharedFlow()

    fun getCategory() {

        viewModelScope.launch(Dispatchers.IO) {

            usecase.execute(CategoryUseCase.Params()).collect { response ->
                when (response) {
                    is DataState.Success -> {
                       // Log.d("VVV", "success from home category")
                        response.value?.let { resp ->
                            _category.emit(resp)
                        }
                    }
                    is DataState.GenericError -> {

                        response.error?.errorResponse?.let { err ->
                            //Log.d("VVV","error from HomeCatViewModel $err")
                            withContext(Dispatchers.Main) {
                                showError.value = "INCORRECT EMAIL OR PASSWORD"
                            }
                        }
                    }
                }
            }

        }
    }
}