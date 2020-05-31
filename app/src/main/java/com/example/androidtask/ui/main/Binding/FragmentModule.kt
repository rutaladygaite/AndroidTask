package com.example.androidtask.ui.main.Binding

import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Component(modules = [AndroidInjectionModule::class,
    ActivitiesModule::class,
    FragmentModule::class])

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}


