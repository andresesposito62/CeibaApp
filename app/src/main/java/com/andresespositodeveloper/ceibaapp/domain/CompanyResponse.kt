package com.andresespositodeveloper.ceibaapp.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CompanyResponse(
   @SerializedName("name") var name: String? = null,
   @SerializedName("catchPhrase") var catchPhrase: String? = null,
   @SerializedName("bs") var bs: String? = null
): Serializable



