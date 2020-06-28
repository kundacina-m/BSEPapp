package com.example.museum.presentation.certificates.info

import androidx.navigation.fragment.navArgs
import com.dropit.ambassador.core.presentation.BaseFragment
import com.example.museum.R
import com.example.museum.databinding.FragmentInfoCertificateBinding
import kotlinx.android.synthetic.main.fragment_info_certificate.*

class InfoCertificateFragment : BaseFragment<InfoCertificateViewModel, FragmentInfoCertificateBinding>() {

    private val args : InfoCertificateFragmentArgs by navArgs()

    override fun getLayoutId(): Int = R.layout.fragment_info_certificate

    override fun initView() {
        etSerial.text = args.certificate.serialNumberSubject
        etCountry.text = args.certificate.country
        etOrganization.text = args.certificate.organization
        etIsCA.text = args.certificate.isCA.toString()
        etIssuer.text = args.certificate.serialNumberIssuer
        etIsRevoked.text = args.certificate.isRevoked.toString()
    }

    override fun setObservers() {
    }

}