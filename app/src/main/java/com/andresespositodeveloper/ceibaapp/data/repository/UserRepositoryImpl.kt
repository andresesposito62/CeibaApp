package com.andresespositodeveloper.ceibaapp.data.repository

import android.util.Log
import com.andresespositodeveloper.ceibaapp.domain.*
import com.andresespositodeveloper.ceibaapp.framework.api.Api
import com.andresespositodeveloper.ceibaapp.framework.datasource.UserDataSource

class UserRepositoryImpl(
    val api: Api
): UserRepository {

    override suspend fun getUserList(): ResultData<List<UserResponse?>> {
        val geo = GeoResponse("123", "")
        val addressResponse = AddressResponse("", "", "", "", geo)
        val companyResponse = CompanyResponse("", "", "")
        val user = UserResponse("", "", "", "", addressResponse, "", "", companyResponse)


        //return ResultData.Success(userList)

        var result2: ResultData<List<UserResponse?>>? = null

        val result = api.getUsers()//transactionAuthorizationRemoteSource.postTransactionAuthorization(authorization, transactionAuthorizationBody)
        when (result){
            is ResultData.Success<*> -> {
                result2 = ResultData.Success(listOf<UserResponse?>(result.value as UserResponse?))
                return  result2
            }//Log.d("TAG-1", result.toString())//storeTransactionInDatabase(transactionAuthorizationBody, result.value as AuthorizationResponse)
        }
        return result2!!
    }
}