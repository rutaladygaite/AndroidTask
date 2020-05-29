package com.example.androidtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class List : AppCompatActivity() {
    //This is a second layout/activity to represent RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }
}
