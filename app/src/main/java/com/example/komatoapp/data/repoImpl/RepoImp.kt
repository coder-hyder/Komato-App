package com.example.komatoapp.data.repoImpl

import com.example.komatoapp.common.ResultState
import com.example.komatoapp.common.USER_COLLECTION
import com.example.komatoapp.domain.models.UserData
import com.example.komatoapp.domain.repo.Repo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import jakarta.inject.Inject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class RepoImp @Inject constructor(val firebaseAuth: FirebaseAuth, val firestore: FirebaseFirestore) : Repo {

    override fun registerWithEmailAndPassword(userData: UserData): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)

            firebaseAuth.createUserWithEmailAndPassword(userData.email,userData.password)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        firestore.collection(USER_COLLECTION)
                            .document(it.result?.user?.uid.toString()).set(userData)
                            .addOnCompleteListener {
                                if (it.isSuccessful){
                                    trySend(ResultState.Success("User Registered Successfully"))
                                }else{
                                    if (it.exception !=null){
                                        trySend(ResultState.Error(it.exception?.localizedMessage.toString()))
                                    }

                                }
                            }
                        trySend(ResultState.Success("User Registered Successfully"))

                    }else{
                        if (it.exception !=null){
                            trySend(ResultState.Error(it.exception?.localizedMessage.toString()))
                        }
                    }
                }

            awaitClose { close() }

        }
    override fun loginWithEmailAndPassword(userData: UserData): Flow<ResultState<String>>  = callbackFlow{

            trySend(ResultState.Loading)

        firebaseAuth.signInWithEmailAndPassword(userData.email, userData.password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    trySend(ResultState.Success("User Logged In Successfully"))
                }else{
                    if (it.exception !=null){
                        trySend(ResultState.Error(it.exception?.localizedMessage.toString()))
                    }
                }
            }
        awaitClose { close() }
    }
}