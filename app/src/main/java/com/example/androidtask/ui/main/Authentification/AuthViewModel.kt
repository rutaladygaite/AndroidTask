package com.example.androidtask.ui.main.Authentification

import androidx.lifecycle.ViewModel
import com.example.androidtask.ui.main.Database.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthViewModel (private val repository: UserRepository): ViewModel () {

    fun getLoggedInUser() = repository.getUser()

    suspend fun userLogin(
        username: String,
        password: String
    ) = withContext(Dispatchers.IO) { repository.userLogin(username, password) }

    suspend fun saveLoggedInUser(user: User) = repository.saveUser(user)

}