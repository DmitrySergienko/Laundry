package com.laundry.presentation.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private var _amount = MutableLiveData(0)
    val amount: LiveData<Int> = _amount

    private var _item = MutableLiveData(0)
    val item: LiveData<Int> = _item

    fun saveItemCount(newAmount: Int){
        _amount.value = newAmount
    }

    fun saveMainItem(position: Int){
        _item.value = position
    }

}