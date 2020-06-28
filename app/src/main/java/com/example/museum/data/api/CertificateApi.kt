package com.example.museum.data.api

import com.example.museum.data.model.CSR
import com.example.museum.data.model.Certificate
import com.example.museum.utils.JWTTokenHolder
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface CertificateApi {

    @Headers(
        "Accept: application/json",
        "User-Agent: bsep",
        "Cache-Control: max-age=640000"
    )
    @POST("certificates/create/selfSigned")
    fun addSelfSignedCertificate(
        @Body certificate: Certificate,
        @Header("Authorization") token: String = JWTTokenHolder.jwt
    ): Completable

    @Headers(
        "Accept: application/json",
        "User-Agent: bsep",
        "Cache-Control: max-age=640000"
    )
    @POST("certificates/create/signed")
    fun addSignedCertificate(
        @Body certificate: Certificate,
        @Header("Authorization") token: String = JWTTokenHolder.jwt
    ): Completable

    @Headers(
        "Accept: application/json",
        "User-Agent: bsep",
        "Cache-Control: max-age=640000"
    )

    @GET("certificates/fetch/all")
    fun fetchAllCertificates(
        @Header("Authorization") token: String = JWTTokenHolder.jwt
    ): Single<List<Certificate>>

    @POST("certificates/revoke")
    fun revokeCertificate(
        @Body certificate: Certificate,
        @Header("Authorization") token: String = JWTTokenHolder.jwt
    ): Completable

    @POST("certificates/isRevoked")
    fun isRevokedCertificate(
        @Body certificate: Certificate,
        @Header("Authorization") token: String = JWTTokenHolder.jwt
    ): Single<Boolean>

}