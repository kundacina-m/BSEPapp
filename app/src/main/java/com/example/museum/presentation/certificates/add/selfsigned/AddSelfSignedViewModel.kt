package com.example.museum.presentation.certificates.add.selfsigned

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dropit.ambassador.core.domain.IDisposable
import com.dropit.ambassador.core.presentation.BaseViewModel
import com.example.museum.data.api.CertificateApi
import com.example.museum.data.model.CSR
import com.example.museum.data.model.Certificate
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class AddSelfSignedViewModel @Inject constructor(val certificateApi: CertificateApi) :
    BaseViewModel() {

    val isAdded = MutableLiveData<Boolean>()

    fun addCertificate(certificate: Certificate) {
        certificateApi.addSelfSignedCertificate(certificate)
            .subscribeOn(Schedulers.io())
            .subscribe({
                isAdded.postValue(true)
            },
                {
                    Log.e("rewr", "erwew")
                })
    }

}

fun generateCertificate(issuer: String = "22222")=
    Certificate(
        organization = "orgnanization",
        country = "sa",
        email = "email",
        endDate = Date().toString(),
        startDate = Date().toString(),
        serialNumberSubject = "1111111111",
        serialNumberIssuer = issuer,
        isCA = true,
        isRevoked = false
    )

fun generateCertificate2(issuer: String = "22222")=
    Certificate(
        organization = "orgnasanization",
        country = "sa",
        email = "emaidasdl",
        endDate = Date().toString(),
        startDate = Date().toString(),
        serialNumberSubject = "1111423111111",
        serialNumberIssuer = issuer,
        isCA = true,
        isRevoked = false
    )