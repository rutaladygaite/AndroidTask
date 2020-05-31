package com.example.androidtask.ui.main.Binding

import com.example.androidtask.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [(MainActivity::class)])
    abstract fun contributeActivityAndroidInjector(): MainActivity
}