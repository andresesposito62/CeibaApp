package com.andresespositodeveloper.ceibaapp.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AddressResponse(
    @SerializedName("street") var street: String? = null,
    @SerializedName("suite") var suite: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("zipcode") var zipcode: String? = null,
    @SerializedName("geo") var geo: GeoResponse? = null
): Serializable


