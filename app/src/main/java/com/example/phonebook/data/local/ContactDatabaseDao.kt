package com.example.phonebook.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.phonebook.data.model.Contact

@Dao
interface ContactDatabaseDao {

    //Funktionen, mit denen auf den Inhalt der Contact-Tabelle in der ContactDatabse zugegriffen werden kann

    // getAll() führt die Query aus, die in der folgenden Zeile übergeben wird.
    @Query("SELECT * FROM Contact")
    fun getAll(): LiveData<List<Contact>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)

    @Update
    fun update(contact: Contact)

    @Delete
    fun delete(contact: Contact)
}