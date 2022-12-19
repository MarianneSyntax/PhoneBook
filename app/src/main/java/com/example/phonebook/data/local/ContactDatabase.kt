package com.example.phonebook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.phonebook.data.model.Contact

class ContactDatabase {


    @Database(entities = [Contact::class], version = 1)
    abstract class ContactDatabase : RoomDatabase() {

        abstract val contactDatabaseDao: ContactDatabaseDao
    }

    //todo: diese ContactDatabase in die instanz variable schreiben, sodass unsere app nur diese ein ContactDatabase hat

    //todo getDatabase() Funktion schreiben, die eine ContactDatabase baut, falls noch keine vorhanden ist

}