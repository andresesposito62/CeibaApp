package com.andresespositodeveloper.ceibaapp.data.repository

import com.andresespositodeveloper.ceibaapp.domain.ResultData
import com.andresespositodeveloper.ceibaapp.domain.User
import com.andresespositodeveloper.ceibaapp.framework.datasource.UserDataSource

class UserRepositoryImpl(
    val userDataSource: UserDataSource
): UserRepository {

    override suspend fun getUserList(): ResultData<List<User?>> {
        val user = User("", "", "", "")
        val userList = listOf<User>(user)
        return ResultData.Success(userList)
    }
}