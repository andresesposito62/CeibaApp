package com.andresespositodeveloper.ceibaapp.domain

data class UserResponse(
    val id: String?,
    val name: String?,
    val username: String?,
    val email: String?,
    val address: AddressResponse?,
    val phone: String?,
    val webSite:String?,
    val company: CompanyResponse?
)




