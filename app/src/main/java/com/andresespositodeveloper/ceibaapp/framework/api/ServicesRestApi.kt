package com.andresespositodeveloper.ceibaapp.framework.api

import com.andresespositodeveloper.ceibaapp.domain.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ServicesRestApi {

    @GET(ServicesEndPoints.GET_USERS)
    fun getUsers(
        //@Header(AUTHORIZATION) authorization: String,
        //@Body transactionAuthorizationBody: TransactionAuthorizationBody
    ): Call<List<UserResponse?>>?

    /*@POST(ServicesEndPoints.POST_ANNULMENT)
    fun transactionAnnulmentResponse(
        @Header(AUTHORIZATION) authorization: String,
        @Body transactionAnnulmentBody: TransactionAnnulmentBody
    ): Call<AnnulmentResponse>?*/

    companion object{
        const val AUTHORIZATION = "Authorization"
    }
}