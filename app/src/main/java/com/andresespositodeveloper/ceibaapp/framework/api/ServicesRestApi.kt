package com.andresespositodeveloper.ceibaapp.framework.api

import com.andresespositodeveloper.ceibaapp.domain.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ServicesRestApi {

    @GET(ServicesEndPoints.POST_AUTHORIZATION)
    fun transactionAuthorizationResponse(
        //@Header(AUTHORIZATION) authorization: String,
        //@Body transactionAuthorizationBody: TransactionAuthorizationBody
    ): Call<UserResponse>?

    /*@POST(ServicesEndPoints.POST_ANNULMENT)
    fun transactionAnnulmentResponse(
        @Header(AUTHORIZATION) authorization: String,
        @Body transactionAnnulmentBody: TransactionAnnulmentBody
    ): Call<AnnulmentResponse>?*/

    companion object{
        const val AUTHORIZATION = "Authorization"
    }
}