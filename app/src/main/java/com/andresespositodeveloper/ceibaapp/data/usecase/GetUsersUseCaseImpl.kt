package com.andresespositodeveloper.ceibaapp.data.usecase

import com.andresespositodeveloper.ceibaapp.data.repository.UserRepository
import com.andresespositodeveloper.ceibaapp.domain.ResultData
import com.andresespositodeveloper.ceibaapp.domain.User

class GetUsersUseCaseImpl(
    val userRepository: UserRepository
): GetUsersUseCase {

    override suspend fun getUserList(): ResultData<List<User?>> {
        return userRepository.getUserList()
    }
}