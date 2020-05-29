package com.example.androidtask.ui.main.Authentification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtask.R

class SwitchingScreens : AppCompatActivity() {

    //This class is to change screens from main to the List screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

    }
}