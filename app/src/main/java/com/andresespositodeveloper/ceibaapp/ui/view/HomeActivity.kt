package com.andresespositodeveloper.ceibaapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andresespositodeveloper.ceibaapp.R
import com.andresespositodeveloper.ceibaapp.data.repository.UserRepository
import com.andresespositodeveloper.ceibaapp.data.usecase.GetUsersUseCase
import com.andresespositodeveloper.ceibaapp.ui.viewmodel.HomeViewModelImpl

class HomeActivity : AppCompatActivity() {

    var viewModel: HomeViewModelImpl? = null
    var getUserUseCase: GetUsersUseCase? = null
    var userRepository: UserRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        /*userRepository = UserRepositoryImpl(userDataSource as UserDataSourceImpl)
        getUserUseCase = GetUsersUseCaseImpl(userRepository as UserRepositoryImpl)
        viewModel = HomeViewModelImpl(getUserUseCase as GetUsersUseCaseImpl)
        viewModel?.getUsers()*/
    }
}