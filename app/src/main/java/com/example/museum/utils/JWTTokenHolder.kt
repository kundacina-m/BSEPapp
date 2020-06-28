package com.example.museum.utils

object JWTTokenHolder {

    var jwt = "Basic YWRtaW46YWRtaW4xMjM="
    fun setJwtToken(token: String) { jwt =  "Bearer $token" }
}