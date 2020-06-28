package com.example.museum.presentation.certificates.add

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dropit.ambassador.core.presentation.BaseFragment
import com.example.museum.R
import com.example.museum.data.model.CSR
import com.example.museum.data.model.Certificate
import com.example.museum.databinding.FragmentAddCertificateBinding
import kotlinx.android.synthetic.main.fragment_add_certificate.*
import kotlinx.android.synthetic.main.fragment_add_certificate.btAdd
import kotlinx.android.synthetic.main.fragment_add_certificate.etCountry
import kotlinx.android.synthetic.main.fragment_add_certificate.etEmail
import kotlinx.android.synthetic.main.fragment_add_certificate.etEndDate
import kotlinx.android.synthetic.main.fragment_add_certificate.etOrganization
import kotlinx.android.synthetic.main.fragment_add_certificate.etSerial
import kotlinx.android.synthetic.main.fragment_add_certificate.etStartDay
import kotlinx.android.synthetic.main.fragment_add_self_signed.*

class AddCertificateFragment : BaseFragment<AddCertificateViewModel, FragmentAddCertificateBinding>() {

    private val navController: NavController by lazy {
        Navigation.findNavController(activity!!, R.id.nav_host_fragment)
    }

    override fun getLayoutId(): Int = R.layout.fragment_add_certificate

    override fun initView() {
        btAdd.setOnClickListener {
            if (infoIsValid()) {
                addCertificate()
            } else
            Toast.makeText(context,"Provided info is not valid!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addCertificate() {

        if (etCountry.text.length != 2) { showToast("Country name is 2 chars!") ; return }
        if (etOrganization.text.isNullOrEmpty()) { showToast("Organization can't be empty") ; return }
        if (etSerial.text.length > 20 || etSerial.text.length < 5) { showToast("Serial numbers need to be between 5 and 20") ; return }
        if (etIssuer.text.length > 20 || etIssuer.text.length < 5) { showToast("Serial numbers need to be between 5 and 20") ; return }


        viewModel.addCertificate(
            Certificate(
                country = etCountry.text.toString(),
                organization = etOrganization.text.toString(),
                email = etEmail.text.toString(),
                startDate = etStartDay.text.toString(),
                endDate = etEndDate.text.toString(),
                isRevoked = false,
                isCA = cbIsCA.isChecked,
                serialNumberIssuer = etIssuer.text.toString(),
                serialNumberSubject = etSerial.text.toString()
            )
        )
    }

    private fun infoIsValid(): Boolean {
        if (etOrganization.text.length < 5) { showToast("Organization name must be at least 5 characters long!") ; return false; }
        if (etCountry.text.length != 2 && etCountry.text.contains(" ").not()) { showToast("Country name is 2 chars!") ; return false;}
        return true

    }

    override fun setObservers() {
        viewModel.isAdded.observe(this, Observer {
            if (it) { showToast("Successfully added certificate") ; navController.navigateUp() }
            else showToast("Certificates adding was unsuccessful!")
        })
    }

}