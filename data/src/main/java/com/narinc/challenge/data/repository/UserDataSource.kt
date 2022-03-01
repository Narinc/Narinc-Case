package com.narinc.challenge.data.repository

import com.narinc.challenge.data.models.UserEntity

interface UserDataSource {
    suspend fun saveUser(user: UserEntity)
    suspend fun getUser(): UserEntity?
}
