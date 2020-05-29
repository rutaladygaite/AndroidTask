package com.example.androidtask.ui.main.Authentification

import com.example.androidtask.ui.main.Database.User

data class AuthResponse(
val isSuccessful: Boolean?,
val message: String?,
val user: User?
)