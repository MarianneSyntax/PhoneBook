package com.example.phonebook.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.phonebook.data.model.Contact




    @Database(entities = [Contact::class], version = 1)
    abstract class ContactDatabase : RoomDatabase() {

        abstract val contactDatabaseDao: ContactDatabaseDao
    }

    // diese ContactDatabase in die instanz variable schreiben, sodass unsere app nur diese ein ContactDatabase hat

    private lateinit var INSTANCE: ContactDatabase

    // getDatabase() Funktion, die eine ContactDatabase baut, falls noch keine vorhanden ist
    fun getDatabase(context: Context): ContactDatabase {
        synchronized(ContactDatabase::class.java) {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    "contact_database_4"
                )
                    .build()
            }
        }
        return INSTANCE
    }



