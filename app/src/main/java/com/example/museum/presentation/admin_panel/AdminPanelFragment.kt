package com.example.museum.presentation.admin_panel

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.dropit.ambassador.core.presentation.BaseFragment
import com.example.museum.R
import com.example.museum.databinding.FragmentAdminPanelBinding
import kotlinx.android.synthetic.main.fragment_admin_panel.*

class AdminPanelFragment : BaseFragment<AdminPanelViewModel, FragmentAdminPanelBinding>() {

    private val navController: NavController by lazy {
        Navigation.findNavController(activity!!, R.id.nav_host_fragment)
    }
    override fun getLayoutId(): Int = R.layout.fragment_admin_panel

    override fun initView() {

        btListCertificates.setOnClickListener {
            navController.navigate(AdminPanelFragmentDirections.actionAdminPanelFragmentToListCertificatesFragment())
        }

        btAddCertificate.setOnClickListener {
            navController.navigate(AdminPanelFragmentDirections.actionAdminPanelFragmentToAddCertificateFragment())
        }

        btSelfSigned.setOnClickListener {
            navController.navigate(AdminPanelFragmentDirections.actionAdminPanelFragmentToAddSelfSignedFragment())
        }
    }

    override fun setObservers() {
    }

}