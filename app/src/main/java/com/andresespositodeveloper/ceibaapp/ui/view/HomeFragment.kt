package com.andresespositodeveloper.ceibaapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andresespositodeveloper.ceibaapp.data.repository.UserRepository
import com.andresespositodeveloper.ceibaapp.data.repository.UserRepositoryImpl
import com.andresespositodeveloper.ceibaapp.data.usecase.GetUsersUseCase
import com.andresespositodeveloper.ceibaapp.data.usecase.GetUsersUseCaseImpl
import com.andresespositodeveloper.ceibaapp.databinding.FragmentHomeBinding
import com.andresespositodeveloper.ceibaapp.framework.api.Api
import com.andresespositodeveloper.ceibaapp.framework.api.ServicesEndPoints
import com.andresespositodeveloper.ceibaapp.framework.api.ServicesRestApi
import com.andresespositodeveloper.ceibaapp.ui.viewmodel.HomeViewModelImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    var viewModel: HomeViewModelImpl? = null
    var getUserUseCase: GetUsersUseCase? = null
    var userRepository: UserRepository? = null
    var api: Api? = null

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        viewModel?.userListResultLiveData?.observe(viewLifecycleOwner) {
            binding.text.text = it.toString()
        }
    }

}