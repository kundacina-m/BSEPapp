package com.example.museum.presentation.certificates.add

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dropit.ambassador.core.presentation.BaseViewModel
import com.example.museum.data.api.CertificateApi
import com.example.museum.data.model.CSR
import com.example.museum.data.model.Certificate
import com.example.museum.presentation.certificates.add.selfsigned.generateCertificate
import com.example.museum.presentation.certificates.add.selfsigned.generateCertificate2
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddCertificateViewModel @Inject constructor(private val certificateApi: CertificateApi) :
    BaseViewModel() {

    val isAdded = MutableLiveData<Boolean>()

    fun addCertificate(certificate: Certificate) {
        certificateApi.addSignedCertificate(certificate)
            .subscribeOn(Schedulers.io())
            .subscribe({
                isAdded.postValue(true)
            },
                {
                    Log.e("rewr", "erwew")
                })
    }
}