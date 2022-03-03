package com.narinc.challenge.cache

import com.narinc.challenge.cache.dao.UserDao
import com.narinc.challenge.cache.mapper.UserCacheMapper
import com.narinc.challenge.data.models.UserEntity
import com.narinc.challenge.data.repository.UserCache
import javax.inject.Inject

class UserCacheImpl @Inject constructor(
    private val userDao: UserDao,
    private val userCacheMapper: UserCacheMapper
) : UserCache {

    override suspend fun saveUser(userEntity: UserEntity) {
        userCacheMapper.mapToCached(userEntity)?.let {
            userDao.addUser(it)
        }
    }

    override suspend fun getUser(): UserEntity? {
        return userCacheMapper.mapFromCached(userDao.getActiveUser())
    }
}
