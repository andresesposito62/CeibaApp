package com.andresespositodeveloper.ceibaapp.data.usecase

import com.andresespositodeveloper.ceibaapp.data.repository.UserRepository
import com.andresespositodeveloper.ceibaapp.domain.ResultData
import com.andresespositodeveloper.ceibaapp.domain.User
import com.andresespositodeveloper.ceibaapp.domain.UserResponse

class GetUsersUseCaseImpl(
    val userRepository: UserRepository
): GetUsersUseCase {

    override suspend fun getUserList(): ResultData<List<UserResponse?>> {
        return userRepository.getUserList()
    }
}