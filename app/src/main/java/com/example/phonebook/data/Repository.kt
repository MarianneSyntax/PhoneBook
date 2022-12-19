package com.example.phonebook.data

import com.example.phonebook.data.local.ContactDatabase
import com.example.phonebook.data.local.getDatabase

// Repository mit Datenbank im Konstruktor
class Repository(private val database: ContactDatabase) {

    // Zugriff auf getAll() über die Datenbank aus dem Konstrutkor, die eine abstract DAO hat
    val contacts = database.contactDatabaseDao.getAll()


}

