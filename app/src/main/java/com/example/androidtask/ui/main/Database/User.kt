package com.example.androidtask.ui.main.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

//Entity yo hold certain values in the Database

@Entity
data class User(
    var id: Int? = null,
    var username: String? = null,
    var password: String? = null
)
{
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}