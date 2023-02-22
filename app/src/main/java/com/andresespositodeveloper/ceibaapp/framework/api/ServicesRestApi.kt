package com.andresespositodeveloper.ceibaapp.framework.api

import com.andresespositodeveloper.ceibaapp.domain.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ServicesRestApi {

    @GET(ServicesEndPoints.GET_USERS)
    fun getUsers(): Call<List<UserResponse?>>?
}