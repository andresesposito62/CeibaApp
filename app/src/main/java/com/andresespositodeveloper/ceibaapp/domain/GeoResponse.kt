package com.andresespositodeveloper.ceibaapp.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GeoResponse (
    @SerializedName("lat") var lat: String? = null,
    @SerializedName("lng") var lng: String ? = null
): Serializable

