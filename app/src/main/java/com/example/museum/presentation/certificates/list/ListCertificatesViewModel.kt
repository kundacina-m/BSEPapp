package com.example.museum.presentation.certificates.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dropit.ambassador.core.presentation.BaseViewModel
import com.example.museum.data.api.CertificateApi
import com.example.museum.data.model.Certificate
import com.example.museum.presentation.certificates.add.selfsigned.generateCertificate
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListCertificatesViewModel @Inject constructor(private val certificateApi: CertificateApi) :
    BaseViewModel() {

    val certificates = MutableLiveData<List<Certificate>>()

    init {
        fetchCertificates()
    }

    private fun fetchCertificates() {

        certificateApi.fetchAllCertificates()
            .subscribeOn(Schedulers.io())
            .subscribe({
                certificates.postValue(it)
            },
                {
                    Log.e("ERROR", "ERROR")
                })
    }

    fun revokeCertificate(certificate: Certificate) {
        certificateApi.revokeCertificate(certificate)
            .subscribeOn(Schedulers.io())
            .subscribe({

            }, {

            })
    }

    fun checkIfRevoked() {
        certificateApi.isRevokedCertificate(generateCertificate())
            .subscribeOn(Schedulers.io())
            .subscribe({

            }, {

            })
    }

}