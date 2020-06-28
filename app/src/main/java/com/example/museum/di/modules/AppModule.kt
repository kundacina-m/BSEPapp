package com.example.museum.di.modules

import android.content.Context
import com.example.museum.MasterApplication
import com.example.museum.data.api.CertificateApi
import com.example.museum.data.api.CustomTrust
import com.example.museum.data.api.LoginApi
import com.example.museum.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession

const val API_URL = "https://192.168.0.101:8089/"

@Module
class AppModule {

    @Provides
    fun provideContext(application: MasterApplication): Context =
        application.applicationContext


    @Singleton
    @Provides
    fun provideLoginApi(): LoginApi {

        return Retrofit.Builder()
            .client(CustomTrust().client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API_URL)
            .build()
            .create(LoginApi::class.java)
    }

    @Singleton
    @Provides
    fun provideCertificateApi(): CertificateApi =
        Retrofit.Builder()
            .client(CustomTrust().client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(API_URL)
            .build()
            .create(CertificateApi::class.java)

}