package com.example.komatoapp.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.komatoapp.common.ResultState
import com.example.komatoapp.domain.models.UserData
import com.example.komatoapp.domain.userCases.CreateUserUseCase
import com.example.komatoapp.domain.userCases.LoginUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class KomatoViewModel @Inject constructor(
    private val createUserCase: CreateUserUseCase,
    private val loginUserUseCase: LoginUserUseCase
): ViewModel() {
    private val _signUpScreenState = MutableStateFlow(SignUpScreenState())
    val signUpScreenState = _signUpScreenState.asStateFlow()

    private val _loginScreenState = MutableStateFlow(LoginScreenState())
    val loginScreenState = _loginScreenState.asStateFlow()


    fun createUser(userData: UserData) {
        viewModelScope.launch {
            createUserCase.createUser(userData).collectLatest {
                when(it){
                    is ResultState.Error -> _signUpScreenState.value = SignUpScreenState(error = it.message)
                    is ResultState.Success -> _signUpScreenState.value = SignUpScreenState(data = it.data)
                    is ResultState.Loading -> _signUpScreenState.value = SignUpScreenState(isLoading = true)
                }
            }
        }
    }

    fun loginUser(userData : UserData){
        viewModelScope.launch {
            loginUserUseCase.loginUser(userData).collectLatest {
                when(it){
                    is ResultState.Error -> _loginScreenState.value = LoginScreenState(error = it.message)
                    is ResultState.Success -> _loginScreenState.value = LoginScreenState(data = it.data)
                    is ResultState.Loading -> _loginScreenState.value = LoginScreenState(isLoading = true)
                }
            }
        }
    }
}

data class SignUpScreenState(
    val isLoading:Boolean = false,
    var data :String? = null,
    var error : String? = null
)

data class LoginScreenState(
    val isLoading:Boolean = false,
    var data :String? = null,
    var error : String? = null
)