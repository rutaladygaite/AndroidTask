package com.example.androidtask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.example.androidtask.ui.main.Binding.ApiException
import com.example.androidtask.databinding.MainActivityBinding
import com.example.androidtask.ui.main.API.AuthListener
import com.example.androidtask.ui.main.Authentification.AuthViewModel
import com.example.androidtask.ui.main.Authentification.AuthViewModelFactory
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    var password: EditText? = null
    var username: EditText? = null

    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()

    private lateinit var binding: MainActivityBinding
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        // Sadly, enabling this, app crashes, can't find why :D

        //viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

/*
        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if (user != null) {
                Intent(this, SwitchingScreens::class.java)
            }
        })*/

        //Find all the layout ids
        val button = findViewById<Button>(R.id.button)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)

        var authListener: AuthListener? = null

        //New layout window (temporary one)

        button.setOnClickListener {
            val intent = Intent(this, List::class.java)
            startActivity(intent)
        }

        // Button that should push viewModel and access API
        // binding.button.setOnClickListener { loginUser() }
    }

    private fun loginUser() {

        val username = binding.username.text.toString().trim()
        val password = binding.password.text.toString().trim()

        lifecycleScope.launch {
            try {
                val authResponse = viewModel.userLogin(username, password)
                if (authResponse.user != null) {
                    viewModel.saveLoggedInUser(authResponse.user)
                }
            } catch (e: ApiException) {
                e.printStackTrace()
            }
        }
    }
}
