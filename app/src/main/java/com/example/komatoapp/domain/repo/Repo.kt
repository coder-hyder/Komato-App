package com.example.komatoapp.domain.repo

import com.example.komatoapp.common.ResultState
import com.example.komatoapp.domain.models.UserData
import kotlinx.coroutines.flow.Flow

interface Repo {
    fun loginWithEmailAndPassword(userData: UserData): Flow<ResultState<String>>

    fun registerWithEmailAndPassword(userData: UserData): Flow<ResultState<String>>
}