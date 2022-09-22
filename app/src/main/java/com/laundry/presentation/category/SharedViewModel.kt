package com.laundry.presentation.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private var _amount = MutableLiveData("0")
    val amount: LiveData<String> = _amount

    fun saveItemCount(newAmount: String){
        _amount.value = newAmount
    }

}