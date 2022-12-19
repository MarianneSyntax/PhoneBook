package com.example.phonebook.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phonebook.data.Repository
import com.example.phonebook.data.local.getDatabase
import com.example.phonebook.data.model.Contact
import kotlinx.coroutines.launch

// neue Syntax im ViewModel Kopf! Android application
class MainViewModel(application: Application) : AndroidViewModel(application) {

    // datenbank aus unserem App Context holen
    private val database = getDatabase(application)
    // gleiche datenbank für Erstellung einer Instanz von Repository nutzen
    private val repo = Repository(database)

    // speichert das Ergebnis vom repo aufruf von getAll() aus dem DAO
    val contacts = repo.contacts

    fun insertContact(contact: Contact) {
        viewModelScope.launch {
            try {
                repo.insertContact(contact)
            } catch (e: Exception) {
                Log.e("MainViewModel", "failed inserting contact: $e")
            }
        }
    }
}