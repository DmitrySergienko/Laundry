package com.laundry.data.repository.datastore

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataStoreViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DataStoreRepository(application)

    val readFromDataStore = repository.readFromDataStore.asLiveData()

    fun saveToDataStore(myName: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.saveInDataStore(myName)
    }

//    fun save(key: String, value: String) = viewModelScope.launch(Dispatchers.IO) {
//        repository.save(key, value)
//    }
//
//    fun read(key: String) = viewModelScope.launch(Dispatchers.IO) {
//        repository.read(key)
//    }
}