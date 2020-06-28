package com.example.museum.presentation.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dropit.ambassador.core.presentation.BaseViewModel
import com.example.museum.data.api.LoginApi
import com.example.museum.data.model.LoginRequest
import com.example.museum.utils.JWTTokenHolder
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginApi: LoginApi) : BaseViewModel() {

    val isLogged = MutableLiveData<Boolean>()

    fun login(loginRequest: LoginRequest) {
        loginApi.login(loginRequest)
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    JWTTokenHolder.setJwtToken(it.string())
                    isLogged.postValue(true)
                }
                , {
                    Log.e("ere", "Rere")
                }
            )
    }
}
