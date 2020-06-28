package com.example.museum.presentation.register

import androidx.lifecycle.MutableLiveData
import com.dropit.ambassador.core.presentation.BaseViewModel
import com.example.museum.data.api.LoginApi
import com.example.museum.data.model.RegisterRequest
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RegisterViewModel @Inject constructor(private val loginApi: LoginApi) : BaseViewModel() {

    val userCreated = MutableLiveData<Boolean>()

    fun register(registerRequest: RegisterRequest) {
        loginApi.register(registerRequest)
            .subscribeOn(Schedulers.io())
            .subscribe({
                userCreated.postValue(true)
            }, {
                userCreated.postValue(false)

            })
    }
}