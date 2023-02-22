package com.andresespositodeveloper.ceibaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andresespositodeveloper.ceibaapp.data.repository.UserRepository
import com.andresespositodeveloper.ceibaapp.data.repository.UserRepositoryImpl
import com.andresespositodeveloper.ceibaapp.data.usecase.GetUsersUseCase
import com.andresespositodeveloper.ceibaapp.data.usecase.GetUsersUseCaseImpl
import com.andresespositodeveloper.ceibaapp.framework.datasource.UserDataSourceImpl
import com.andresespositodeveloper.ceibaapp.ui.viewmodel.HomeViewModelImpl

class MainActivity : AppCompatActivity() {

    var viewModel: HomeViewModelImpl? = null
    var getUserUseCase: GetUsersUseCase? = null
    var userRepository: UserRepository? = null
    var userDataSource: UserDataSourceImpl? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userDataSource = UserDataSourceImpl()
        userRepository = UserRepositoryImpl(userDataSource as UserDataSourceImpl)
        getUserUseCase = GetUsersUseCaseImpl(userRepository as UserRepositoryImpl)
        viewModel = HomeViewModelImpl(getUserUseCase as GetUsersUseCaseImpl)
        viewModel?.getUsers()
    }
}