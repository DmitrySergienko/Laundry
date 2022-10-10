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
const val PREFERENCE_TOKEN = "token"

class DataStoreRepository(context: Context) {

    private object PrefernceKey {
        val name = preferencesKey<String>("my_name")
        val token = preferencesKey<String>("token")

    }

    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = PREFERENCE_NAME
    )
    private val dataStoreToken: DataStore<Preferences> = context.createDataStore(
        name = PREFERENCE_TOKEN
    )

    suspend fun saveInDataStore(value: String) {
        dataStore.edit { preference ->
            preference[PrefernceKey.name] = value

        }
    }
    suspend fun saveTokenDataStore(value: String) {
        dataStoreToken.edit { preference ->
            preference[PrefernceKey.token] = value

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

    val readTokenDataStore: Flow<String> = dataStoreToken.data
        .catch { exception ->
            if (exception is IOException) {
                // Log.d("DataStore", exception.message.toString())
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preference->
            val defaultValue = preference[PrefernceKey.name] ?: "no token saved"
            defaultValue

        }


}



