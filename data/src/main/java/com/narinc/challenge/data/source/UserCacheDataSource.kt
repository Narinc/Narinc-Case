package com.narinc.challenge.data.source

import com.narinc.challenge.data.models.UserEntity
import com.narinc.challenge.data.repository.UserCache
import com.narinc.challenge.data.repository.UserDataSource
import javax.inject.Inject

class UserCacheDataSource @Inject constructor(
    private val userCache: UserCache
) : UserDataSource {

    override suspend fun saveUser(user: UserEntity) {
        userCache.saveUser(user)
    }

    override suspend fun getUser(): UserEntity = userCache.getUser()
}
