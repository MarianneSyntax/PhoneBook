package com.example.phonebook.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity // Contact ist eine Entity in der datenbank, heißt bekommt eine tabelle in der datenbank generiert
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    var name: String,
    var number: String
)
