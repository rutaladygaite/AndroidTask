package com.example.androidtask.ui.main.API

import androidx.room.Entity

interface AuthListener {

    fun onStarted()
    @Entity
    data class User(
        var username: String? = null,
        var password: String? = null
    )
    fun onFailure(message: String)
}
