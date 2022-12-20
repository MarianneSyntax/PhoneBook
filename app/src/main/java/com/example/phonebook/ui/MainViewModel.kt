package com.example.phonebook.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phonebook.data.Repository
import com.example.phonebook.data.local.getDatabase
import com.example.phonebook.data.model.Contact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// neue Syntax im ViewModel Kopf! Android application
class MainViewModel(application: Application) : AndroidViewModel(application) {

    // datenbank aus unserem App Context holen
    private val database = getDatabase(application)
    // gleiche datenbank für Erstellung einer Instanz von Repository nutzen
     val repo = Repository(database)

    // speichert das Ergebnis vom repo aufruf von getAll() aus dem DAO
    val contacts = repo.getAllContacts()

    fun insertContact(contact: Contact) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                repo.insertContact(contact)
            } catch (e: Exception) {
                Log.e("MainViewModel", "failed inserting contact: $e")
            }
        }

    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch{
            try {
                repo.deleteContact(contact)
            } catch (e: Exception) {
                Log.e("MainViewModel", "failed deleting contact: $e")
            }
        }
    }

    fun updateContact(contact: Contact) {
        viewModelScope.launch {
            try {
                repo.updateContact(contact)
            } catch (e: Exception) {
                Log.e("MainViewModel", "failed updating contact: $e")
            }
        }
    }
}