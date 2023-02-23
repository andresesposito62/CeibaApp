package com.andresespositodeveloper.ceibaapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andresespositodeveloper.ceibaapp.data.usecase.GetUsersUseCase
import com.andresespositodeveloper.ceibaapp.domain.ResultData
import com.andresespositodeveloper.ceibaapp.domain.User
import com.andresespositodeveloper.ceibaapp.domain.UserResponse
import kotlinx.coroutines.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModelImpl(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel(), HomeViewModel {

    private var getUserListJob: Job? = null

    private val userListError: MutableLiveData<String> = MutableLiveData()
    private val userListResult: MutableLiveData<List<UserResponse?>> = MutableLiveData()

    val userListErrorLiveData: LiveData<String> = userListError
    val userListResultLiveData: LiveData<List<UserResponse?>> = userListResult

    fun getUsers(){
        getUserListJob?.cancel()
        getUserListJob = viewModelScope.launch {
            val result: ResultData<List<UserResponse?>> = withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
                getUsersUseCase.getUserList()
            }
            when(result){
                is ResultData.Success -> userListResult.postValue(result.value!!)//Log.d("TAG-1","Listado de usuarios: ${result.value.toString()}")//setTransactionData(result.value[0])
                is ResultData.Failure -> Log.d("TAG-1","Error Listado de usuarios: ${result.throwable.stackTrace.toString()}")
            }
        }
    }
}