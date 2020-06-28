package com.example.museum.di.components

import com.example.museum.MasterApplication
import com.example.museum.di.modules.ActivitiesInjector
import com.example.museum.di.modules.AppModule
import com.example.museum.di.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ActivitiesInjector::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<MasterApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MasterApplication>

}