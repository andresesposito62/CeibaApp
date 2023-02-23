package com.andresespositodeveloper.ceibaapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andresespositodeveloper.ceibaapp.R
import com.andresespositodeveloper.ceibaapp.data.repository.UserRepository
import com.andresespositodeveloper.ceibaapp.data.repository.UserRepositoryImpl
import com.andresespositodeveloper.ceibaapp.data.usecase.GetUsersUseCase
import com.andresespositodeveloper.ceibaapp.data.usecase.GetUsersUseCaseImpl
import com.andresespositodeveloper.ceibaapp.framework.api.Api
import com.andresespositodeveloper.ceibaapp.framework.api.ServicesEndPoints
import com.andresespositodeveloper.ceibaapp.framework.api.ServicesRestApi
import com.andresespositodeveloper.ceibaapp.ui.viewmodel.HomeViewModelImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    var viewModel: HomeViewModelImpl? = null
    var getUserUseCase: GetUsersUseCase? = null
    var userRepository: UserRepository? = null
    var api: Api? = null
    lateinit var servicesRestApi: ServicesRestApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val  retrofit: Retrofit
                = Retrofit.Builder()
            .baseUrl(ServicesEndPoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val servicesRestApi: ServicesRestApi =retrofit.create(ServicesRestApi::class.java)

        api = Api(servicesRestApi)
        userRepository = UserRepositoryImpl(api!!)
        getUserUseCase = GetUsersUseCaseImpl(userRepository as UserRepositoryImpl)
        viewModel = HomeViewModelImpl(getUserUseCase as GetUsersUseCaseImpl)
        viewModel?.getUsers()
    }
}