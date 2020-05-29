package com.example.androidtask.ui.main.Authentification
import com.example.androidtask.ui.main.API.ApiInterface
import com.example.androidtask.ui.main.Database.AppDatabase
import com.example.androidtask.ui.main.Database.User

class UserRepository (private val api: ApiInterface, private val db: AppDatabase): SafeApiRequest() {

    suspend fun userLogin (username: String, password: String):AuthResponse{
        return apiRequest {api.userLogin(username, password)}
    }

    suspend fun saveUser(user: User): Long = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

}