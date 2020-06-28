package com.example.museum.di.viewmodel

import androidx.lifecycle.ViewModel
import com.dropit.ambassador.core.di.viewmodel.IViewModelFactory
import com.dropit.ambassador.core.di.viewmodel.ViewModelFactory
import com.dropit.ambassador.core.di.viewmodel.ViewModelKey
import com.example.museum.presentation.admin_panel.AdminPanelFragment
import com.example.museum.presentation.admin_panel.AdminPanelViewModel
import com.example.museum.presentation.certificates.CertificatesActivity
import com.example.museum.presentation.certificates.CertificatesViewModel
import com.example.museum.presentation.certificates.add.AddCertificateFragment
import com.example.museum.presentation.certificates.add.AddCertificateViewModel
import com.example.museum.presentation.certificates.add.selfsigned.AddSelfSignedFragment
import com.example.museum.presentation.certificates.add.selfsigned.AddSelfSignedViewModel
import com.example.museum.presentation.certificates.info.InfoCertificateFragment
import com.example.museum.presentation.certificates.info.InfoCertificateViewModel
import com.example.museum.presentation.certificates.list.ListCertificatesFragment
import com.example.museum.presentation.certificates.list.ListCertificatesViewModel
import com.example.museum.presentation.login.LoginActivity
import com.example.museum.presentation.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): IViewModelFactory

    @Binds
    @IntoMap
    @ViewModelKey(LoginActivity::class, LoginViewModel::class)
    internal abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CertificatesActivity::class, CertificatesViewModel::class)
    internal abstract fun bindCertificatesViewModel(certificatesViewModel: CertificatesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AdminPanelFragment::class, AdminPanelViewModel::class)
    internal abstract fun bindAdminPanelViewModel(adminPanelViewModel: AdminPanelViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddCertificateFragment::class, AddCertificateViewModel::class)
    internal abstract fun bindAddCertificateViewModel(addCertificateViewModel: AddCertificateViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(InfoCertificateFragment::class, InfoCertificateViewModel::class)
    internal abstract fun bindInfoCertificateViewModel(infoCertificateViewModel: InfoCertificateViewModel): ViewModel
    @Binds
    @IntoMap
    @ViewModelKey(ListCertificatesFragment::class, ListCertificatesViewModel::class)
    internal abstract fun bindListCertificatesViewModel(listCertificatesViewModel: ListCertificatesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddSelfSignedFragment::class, AddSelfSignedViewModel::class)
    internal abstract fun bindAddSelfSignedViewModel(addSelfSignedViewModel: AddSelfSignedViewModel): ViewModel

}