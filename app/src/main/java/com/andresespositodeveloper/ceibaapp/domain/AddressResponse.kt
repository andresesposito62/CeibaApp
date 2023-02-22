package com.andresespositodeveloper.ceibaapp.domain

data class AddressResponse(
    val street: String?,
    val suite: String?,
    val city: String?,
    val zipCode: String?,
    val geo: GeoResponse
)
