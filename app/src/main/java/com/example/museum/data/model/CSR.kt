package com.example.museum.data.model

data class CSR(

    // Name data
    val countryName: String = "Unknown",
    val organizationName: String = "Unknown",
    val emailAddress: String = "Unknown",

    // Subject data
    val serialNumber: String = "2141312412412",
    val startTimestamp: Long = 0L,
    val endTimestamp: Long = 0L,

    // Flags for choosing jks files and checking validity
    val issuerSerialNumber: String = "Unknown",
    val isCA: Boolean = false
)