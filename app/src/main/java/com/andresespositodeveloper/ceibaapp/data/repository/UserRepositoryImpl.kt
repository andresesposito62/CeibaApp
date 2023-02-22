package com.andresespositodeveloper.ceibaapp.data.repository

import com.andresespositodeveloper.ceibaapp.domain.*
import com.andresespositodeveloper.ceibaapp.framework.api.Api

class UserRepositoryImpl(
    val api: Api
): UserRepository {

    override suspend fun getUserList(): ResultData<List<UserResponse?>> = api.getUsers()

}