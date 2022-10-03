package com.laundry.data.repository.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

const val PREFERENCE_NAME = "my_preference"

class DataStoreRepository(context: Context) {

    private object PrefernceKey {
        val name = preferencesKey<String>("my_name")

    }

    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = PREFERENCE_NAME
    )

    suspend fun saveInDataStore(value: String) {
        dataStore.edit { preference ->
            preference[PrefernceKey.name] = value

        }
    }

    val readFromDataStore: Flow<String> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
               // Log.d("DataStore", exception.message.toString())
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preference->
            val myName = preference[PrefernceKey.name] ?: "none"
            myName

        }

//    suspend fun save(key: String, value: String) {
//        val dataStoreKey = preferencesKey<String>(key)
//        dataStore.edit { settings ->
//            settings[dataStoreKey] = value
//        }
//    }
//    suspend fun read(key: String): String? {
//        val dataStoreKey = preferencesKey<String>(key)
//        val preferences = dataStore.data.first()
//        return preferences[dataStoreKey]
//    }

}

//  binding.btnSave.setOnClickListener {
//            lifecycleScope.launch {
//                save(
//                        binding.etSaveKey.text.toString(),
//                        binding.etSaveValue.text.toString()
//                )
//            }
//        }
//
//        binding.btnRead.setOnClickListener {
//            lifecycleScope.launch {
//                val value = read(binding.etReadkey.text.toString())
//                binding.tvReadValue.text = value ?: "No value found"
//            }
//        }
