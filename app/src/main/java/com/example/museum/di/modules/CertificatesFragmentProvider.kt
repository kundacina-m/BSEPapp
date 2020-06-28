package com.example.museum.di.modules

import com.dropit.ambassador.core.di.scopes.FragmentScope
import com.example.museum.presentation.admin_panel.AdminPanelFragment
import com.example.museum.presentation.certificates.add.AddCertificateFragment
import com.example.museum.presentation.certificates.add.selfsigned.AddSelfSignedFragment
import com.example.museum.presentation.certificates.info.InfoCertificateFragment
import com.example.museum.presentation.certificates.list.ListCertificatesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CertificatesFragmentProvider {


    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeAdminPanelFragmentInjector(): AdminPanelFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeAddCertificateFragmentInjector(): AddCertificateFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeListCertificatesFragmentInjector(): ListCertificatesFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeInfoCertificateFragmentInjector(): InfoCertificateFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeAddSelfSignedFragmentInjector(): AddSelfSignedFragment
}