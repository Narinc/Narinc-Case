package com.narinc.challenge.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun saveUser(user: User)
    suspend fun getUser(): Flow<User>
}
