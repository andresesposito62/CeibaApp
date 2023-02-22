package com.andresespositodeveloper.ceibaapp.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserResponse(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("address") var address: AddressResponse? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("website") var website:String? = null,
    @SerializedName("company") var company: CompanyResponse? = null
): Serializable






