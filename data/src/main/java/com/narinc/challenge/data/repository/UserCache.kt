package com.narinc.challenge.data.repository

import com.narinc.challenge.data.models.UserEntity

interface UserCache {
    suspend fun saveUser(userEntity: UserEntity)
    suspend fun getUser(): UserEntity?
}
