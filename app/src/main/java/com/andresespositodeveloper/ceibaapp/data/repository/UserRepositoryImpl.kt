package com.andresespositodeveloper.ceibaapp.data.repository

import com.andresespositodeveloper.ceibaapp.domain.*
import com.andresespositodeveloper.ceibaapp.framework.datasource.UserDataSource

class UserRepositoryImpl(
    val userDataSource: UserDataSource
): UserRepository {

    override suspend fun getUserList(): ResultData<List<UserResponse?>> {
        val geo = GeoResponse("", "")
        val addressResponse = AddressResponse("", "", "", "", geo)
        val companyResponse = CompanyResponse("", "", "")
        val user = UserResponse("", "", "", "", addressResponse, "", "", companyResponse)

        val userList = listOf<UserResponse>(user)

        return ResultData.Success(userList)
    }
}