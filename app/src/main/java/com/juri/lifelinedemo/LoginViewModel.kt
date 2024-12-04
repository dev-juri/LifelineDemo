package com.juri.lifelinedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juri.lifelinedemo.data.LoginBody
import com.juri.lifelinedemo.repo.RepositoryImpl
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repositoryImpl: RepositoryImpl = RepositoryImpl()

    private val _result = MutableLiveData<LoginBody?>()
    val result: LiveData<LoginBody?> get() = _result

    fun loginUser(loginBody: LoginBody) {
        viewModelScope.launch {
            val response = repositoryImpl.loginUser(loginBody)

            _result.value = response
        }
    }
}