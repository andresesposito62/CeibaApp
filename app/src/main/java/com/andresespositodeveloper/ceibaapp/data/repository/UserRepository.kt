package com.andresespositodeveloper.ceibaapp.data.repository

import com.andresespositodeveloper.ceibaapp.domain.ResultData
import com.andresespositodeveloper.ceibaapp.domain.User

interface UserRepository {
    suspend fun getUserList(): ResultData<List<User?>>
}