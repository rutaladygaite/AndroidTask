package com.example.androidtask.ui.main.Binding

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.androidtask.R
import dagger.android.AndroidInjection

class MainFragment : Fragment() {

    override fun onAttach(context: Context) {
        AndroidInjection.inject(this)
        super.onAttach(context)

    }

    override
    fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                     savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_activity, container, false)
    }

}