package com.example.komatoapp.presentation.di

import com.example.komatoapp.data.repoImpl.RepoImp
import com.example.komatoapp.domain.repo.Repo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {
    @Singleton
    @Provides
    fun provideRepoImp( firebaseAuth : FirebaseAuth,firestore: FirebaseFirestore): Repo{
        return RepoImp(firebaseAuth,firestore)
    }
}