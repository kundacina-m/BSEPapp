package com.example.museum

import android.content.Context
import com.dropit.ambassador.core.presentation.ViewModelIdProvider
import com.example.museum.di.components.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MasterApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        setViewModelID()
    }

    private fun setViewModelID() {
        ViewModelIdProvider.viewModelId = BR.vm
    }
}