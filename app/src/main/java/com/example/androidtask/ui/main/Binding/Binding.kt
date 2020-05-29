package com.example.androidtask.ui.main.Binding

import android.app.Application
import com.example.androidtask.ui.main.API.ApiInterface
import com.example.androidtask.ui.main.Authentification.AuthViewModelFactory
import com.example.androidtask.ui.main.Authentification.UserRepository
import com.example.androidtask.ui.main.Database.AppDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class Binding: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@Binding))
        bind() from singleton { ApiInterface(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
    }
}