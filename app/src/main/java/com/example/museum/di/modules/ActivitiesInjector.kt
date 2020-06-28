package com.example.museum.di.modules

import com.dropit.ambassador.core.di.scopes.ActivityScope
import com.example.museum.presentation.certificates.CertificatesActivity
import com.example.museum.presentation.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesInjector {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeLoginActivityInjector(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [CertificatesFragmentProvider::class]
    )
    abstract fun contributeCertificatesActivityInjector(): CertificatesActivity
}