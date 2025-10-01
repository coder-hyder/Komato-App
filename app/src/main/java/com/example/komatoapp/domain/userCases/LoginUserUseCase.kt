package com.example.komatoapp.domain.userCases

import com.example.komatoapp.common.ResultState
import com.example.komatoapp.domain.models.UserData
import com.example.komatoapp.domain.repo.Repo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LoginUserUseCase @Inject constructor(private val repo: Repo) {
    fun loginUser(userData: UserData): Flow<ResultState<String>>{
        return repo.loginWithEmailAndPassword(userData)
    }
}