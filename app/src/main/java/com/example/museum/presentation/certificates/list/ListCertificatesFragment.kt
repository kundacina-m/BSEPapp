package com.example.museum.presentation.certificates.list

import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.dropit.ambassador.core.presentation.BaseFragment
import com.example.museum.R
import com.example.museum.data.model.Certificate
import com.example.museum.databinding.FragmentListCertificatesBinding
import kotlinx.android.synthetic.main.fragment_list_certificates.*

class ListCertificatesFragment :
    BaseFragment<ListCertificatesViewModel, FragmentListCertificatesBinding>() {

    private val navController: NavController by lazy {
        Navigation.findNavController(activity!!, R.id.nav_host_fragment)
    }

    private val certificatesAdapter by lazy {
        CertificatesAdapter().apply {
            onItemClick = this@ListCertificatesFragment::openCertificateInfo
            onIsRevokedClicked = this@ListCertificatesFragment::isItRevoked
            onRevokeClicked = this@ListCertificatesFragment::revokeCertificate
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_list_certificates

    override fun initView() {

        rvCertificates.run {
            adapter = certificatesAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

    override fun setObservers() {
        viewModel.certificates.observe(this, Observer {
            certificatesAdapter.setData(it)
        })
    }

    private fun revokeCertificate(certificate: Certificate) {
        viewModel.revokeCertificate(certificate)
        showToast("REVOKE")
    }

    private fun isItRevoked(certificate: Certificate) {
        viewModel.checkIfRevoked()
        showToast("IS REVOKED")
    }

    private fun openCertificateInfo(certificate: Certificate) {
        navController.navigate(ListCertificatesFragmentDirections.actionListCertificatesFragmentToInfoCertificateFragment(
            certificate
        ))
    }

}