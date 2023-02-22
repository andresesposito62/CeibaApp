package com.andresespositodeveloper.ceibaapp.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CompanyResponse(
   @SerializedName("name") val name: String?,
   @SerializedName("catchPhrase") val catchPhrase: String?,
   @SerializedName("bs") val bs: String?
): Serializable



