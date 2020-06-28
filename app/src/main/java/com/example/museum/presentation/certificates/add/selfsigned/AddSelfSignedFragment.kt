package com.example.museum.presentation.certificates.add.selfsigned

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dropit.ambassador.core.presentation.BaseFragment
import com.example.museum.R
import com.example.museum.data.model.Certificate
import com.example.museum.databinding.FragmentAddSelfSignedBinding
import kotlinx.android.synthetic.main.fragment_add_self_signed.*
import kotlinx.android.synthetic.main.fragment_add_self_signed.btAdd
import kotlinx.android.synthetic.main.fragment_add_self_signed.etCountry
import kotlinx.android.synthetic.main.fragment_add_self_signed.etEmail
import kotlinx.android.synthetic.main.fragment_add_self_signed.etEndDate
import kotlinx.android.synthetic.main.fragment_add_self_signed.etOrganization
import kotlinx.android.synthetic.main.fragment_add_self_signed.etSerial
import kotlinx.android.synthetic.main.fragment_add_self_signed.etStartDay
import java.text.SimpleDateFormat

class AddSelfSignedFragment: BaseFragment<AddSelfSignedViewModel, FragmentAddSelfSignedBinding>() {

    private val navController: NavController by lazy {
        Navigation.findNavController(activity!!, R.id.nav_host_fragment)
    }

    override fun getLayoutId(): Int = R.layout.fragment_add_self_signed

    override fun initView() {
        btAdd.setOnClickListener {
            if (infoIsValid()) {
                addCertificate()
            } else
                Toast.makeText(context,"Provided info is not valid!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addCertificate() {

        val sdf = SimpleDateFormat("yyyy/MM/dd")


        if (etCountry.text.length != 2) { showToast("Country name is 2 chars!") ; return }
        if (etOrganization.text.isNullOrEmpty()) { showToast("Organization can't be empty") ; return }
        if (etSerial.text.length > 20 || etSerial.text.length < 5) { showToast("Serial numbers need to be between 5 and 20") ; return }

        viewModel.addCertificate(
            Certificate(
                country = etCountry.text.toString(),
                organization = etOrganization.text.toString(),
                email = etEmail.text.toString(),
                startDate = etStartDay.text.toString(),
                endDate = etEndDate.text.toString(),
                isRevoked = false,
                isCA = true,
                serialNumberIssuer = "",
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