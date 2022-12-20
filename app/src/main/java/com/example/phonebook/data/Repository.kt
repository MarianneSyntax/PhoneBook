package com.example.phonebook.data

import androidx.lifecycle.LiveData
import com.example.phonebook.data.local.ContactDatabase
import com.example.phonebook.data.local.getDatabase
import com.example.phonebook.data.model.Contact

// Repository mit Datenbank im Konstruktor
class Repository(private val database: ContactDatabase) {

    // übergebenen Kontakt einfügen
    suspend fun insertContact(contact: Contact) {
        database.contactDatabaseDao.insert(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        database.contactDatabaseDao.delete(contact)
    }

    suspend fun updateContact(contact: Contact) {
        database.contactDatabaseDao.update(contact)
    }

    // Zugriff auf getAll() über die Datenbank aus dem Konstrutkor, die eine abstract DAO hat

    fun getAllContacts(): LiveData<List<Contact>> {
        return database.contactDatabaseDao.getAll()
    }


}

