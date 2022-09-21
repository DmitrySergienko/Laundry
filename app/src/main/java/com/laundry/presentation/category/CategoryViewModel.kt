package com.laundry.presentation.category

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laundry.data.database.CategoryDatabase
import com.laundry.data.database.CategoryRep
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.domain.Category
import com.laundry.domain.usecases.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class CategoryViewModel(application: Application):AndroidViewModel(application) {

    private val readAllData: LiveData<List<CategoryEntity>>
    private val repository: CategoryRep


    init {
        val categoryDao = CategoryDatabase.getDb(application).getCategoryDao()
        repository = CategoryRep(categoryDao)
        readAllData = repository.readAllData
    }

    fun addCategory(category: CategoryEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCategory(category)
        }
    }


}