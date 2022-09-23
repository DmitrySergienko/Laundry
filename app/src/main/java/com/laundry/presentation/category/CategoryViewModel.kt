package com.laundry.presentation.category

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.laundry.data.database.CategoryDatabase
import com.laundry.data.database.CategoryRep
import com.laundry.data.database.entities.CategoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CategoryViewModel(application: Application):AndroidViewModel(application) {

    val readAllData: LiveData<List<CategoryEntity>>
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

    fun cleanCategoryList(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.cleanList()
        }
    }

}