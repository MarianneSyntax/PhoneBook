package com.example.phonebook.data

import com.example.phonebook.data.local.ContactDatabase
import com.example.phonebook.data.local.getDatabase
import com.example.phonebook.data.model.Contact

// Repository mit Datenbank im Konstruktor
class Repository(private val database: ContactDatabase) {

    // Zugriff auf getAll() über die Datenbank aus dem Konstrutkor, die eine abstract DAO hat
    val contacts = database.contactDatabaseDao.getAll()

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


}

