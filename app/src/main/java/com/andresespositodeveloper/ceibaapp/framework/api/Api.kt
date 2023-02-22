package com.andresespositodeveloper.ceibaapp.framework.api

import com.andresespositodeveloper.ceibaapp.domain.ResultData
import com.andresespositodeveloper.ceibaapp.domain.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Api(
    private val servicesRestApi: ServicesRestApi
) {

    suspend fun getUsers(): ResultData<List<UserResponse?>> =
        suspendCoroutine {
            val result = servicesRestApi.getUsers()
            result?.enqueue(object: Callback<List<UserResponse?>>{
                override fun onResponse(
                    call: Call<List<UserResponse?>>,
                    response: Response<List<UserResponse?>>
                ) {
                    if (response.code() in MIN_CODE_SUCCESS..MAX_CODE_SUCCESS){
                        if (response.body() != null){
                            it.resume(ResultData.Success(response.body()!!))
                        }else{
                            it.resume(ResultData.Failure(Exception(response.code().toString())))
                        }
                    }else{
                        it.resume(ResultData.Failure(Exception(response.code().toString())))
                    }
                }

                override fun onFailure(call: Call<List<UserResponse?>>, error: Throwable) {
                    it.resume(ResultData.Failure(error))
                }
            })
        }

    companion object{
        const val MIN_CODE_SUCCESS = 200
        const val MAX_CODE_SUCCESS = 399
    }
}