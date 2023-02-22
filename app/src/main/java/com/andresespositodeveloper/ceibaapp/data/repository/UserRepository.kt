package com.andresespositodeveloper.ceibaapp.data.repository

import com.andresespositodeveloper.ceibaapp.domain.ResultData
import com.andresespositodeveloper.ceibaapp.domain.User
import com.andresespositodeveloper.ceibaapp.domain.UserResponse

interface UserRepository {
    suspend fun getUserList(): ResultData<List<UserResponse?>>
}