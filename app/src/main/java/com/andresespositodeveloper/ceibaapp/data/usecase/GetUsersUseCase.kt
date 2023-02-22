package com.andresespositodeveloper.ceibaapp.data.usecase

import com.andresespositodeveloper.ceibaapp.domain.ResultData
import com.andresespositodeveloper.ceibaapp.domain.User

interface GetUsersUseCase {
    suspend fun getUserList(): ResultData<List<User?>>
}