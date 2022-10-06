package com.laundry.presentation.client.category

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.laundry.data.utils.DataState
import com.laundry.domain.entity.remote.CategoryResponse
import com.laundry.domain.entity.remote.SaveOrder
import com.laundry.domain.entity.remote.SaveOrderResponse
import com.laundry.domain.usecases.CategoryUseCase
import com.laundry.domain.usecases.SaveOrderUseCase
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
    private val usecaseCategory: CategoryUseCase,
    private val usecaseSaveOrder: SaveOrderUseCase

) : BaseViewModel() {

    private val _category = MutableSharedFlow<CategoryResponse>()
    val category = _category.asSharedFlow()

    private val _saveOrder = MutableSharedFlow<SaveOrderResponse>()
    val saveOrder = _saveOrder.asSharedFlow()

    fun getCategory() {

        viewModelScope.launch(Dispatchers.IO) {

            usecaseCategory.execute(CategoryUseCase.Params()).collect { response ->
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

    fun getSaveOrder(post: SaveOrder) {
        viewModelScope.launch(Dispatchers.IO) {
            usecaseSaveOrder.execute(SaveOrderUseCase.Params(post)).collect { response ->

                when (response) {
                    is DataState.Success -> {
                        Log.d("SaveOrder", "save_order_success")
                        response.value?.let { resp ->
                            _saveOrder.emit(resp)
                        }
                    }
                    is DataState.GenericError -> {
                        response.error?.errorResponse?.let { err ->
                            Log.d("SaveOrder", "error $err")
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
