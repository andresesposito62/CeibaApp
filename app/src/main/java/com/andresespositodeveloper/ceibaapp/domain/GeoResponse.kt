package com.andresespositodeveloper.ceibaapp.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GeoResponse (
    @SerializedName("lat") val lat: String?,
    @SerializedName("lng") val lng: String?
): Serializable

