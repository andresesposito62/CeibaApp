package com.andresespositodeveloper.ceibaapp.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("username") val username: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("address") val address: AddressResponse?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("website") val website:String?,
    @SerializedName("company") val company: CompanyResponse?
): Serializable






