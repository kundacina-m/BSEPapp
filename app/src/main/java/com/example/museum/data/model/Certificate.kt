package com.example.museum.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlin.collections.ArrayList

@Parcelize
data class Certificate(
    val id: Long = 0,
    val serialNumberSubject: String,
    val serialNumberIssuer: String,
    val organization: String,
    val country: String,
    val email: String,
    val startDate: String,
    val endDate: String,
    val isCA: Boolean = true,
    var isRevoked: Boolean = false,
    val keyUsage: ArrayList<Int> = arrayListOf(),
    val extendedKeyUsage: ArrayList<String> = arrayListOf(),
    var revocationReason: String? = null,
    var revocationTimestamp: String? = null
) : Parcelable