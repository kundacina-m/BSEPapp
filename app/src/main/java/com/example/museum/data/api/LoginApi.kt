package com.example.museum.data.api

import com.example.museum.data.model.LoginRequest
import com.example.museum.data.model.RegisterRequest
import com.example.museum.utils.JWTTokenHolder
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginApi {

    @Headers(
        "Accept: application/json",
        "User-Agent: bsep",
        "Cache-Control: max-age=640000",
        "Authorization: Basic YWRtaW46YWRtaW4xMjM="
    )
    @POST("auth/login")
    fun login(
        @Body loginRequest: LoginRequest
    ): Single<ResponseBody>

    @Headers(
        "Accept: application/json",
        "User-Agent: bsep",
        "Cache-Control: max-age=640000",
        "Authorization: Basic YWRtaW46YWRtaW4xMjM="
    )
    @POST("auth/login")
    fun register(
        @Body registerRequest: RegisterRequest
    ): Completable

}