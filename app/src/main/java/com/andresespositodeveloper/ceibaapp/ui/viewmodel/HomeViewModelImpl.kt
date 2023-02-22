package com.andresespositodeveloper.ceibaapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andresespositodeveloper.ceibaapp.data.usecase.GetUsersUseCase
import com.andresespositodeveloper.ceibaapp.domain.ResultData
import com.andresespositodeveloper.ceibaapp.domain.User
import kotlinx.coroutines.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModelImpl(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel(), HomeViewModel {

    private var getUserListJob: Job? = null

    fun getUsers(){
        getUserListJob?.cancel()
        getUserListJob = viewModelScope.launch {
            val result: ResultData<List<User?>> = withContext(viewModelScope.coroutineContext + Dispatchers.IO) {
                getUsersUseCase.getUserList()
            }
            when(result){
                is ResultData.Success -> Log.d("TAG-1","Listado de usuarios: ${result.value.toString()}")//setTransactionData(result.value[0])
                is ResultData.Failure -> Log.d("TAG-1","Error Listado de usuarios: ${result.throwable.stackTrace.toString()}")
            }
        }
    }
}