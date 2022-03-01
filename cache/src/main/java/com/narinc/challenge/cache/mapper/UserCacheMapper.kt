package com.narinc.challenge.cache.mapper

import com.narinc.challenge.cache.models.UserCacheEntity
import com.narinc.challenge.data.models.UserEntity
import javax.inject.Inject

class UserCacheMapper @Inject constructor() : CacheMapper<UserCacheEntity?, UserEntity?> {
    override fun mapFromCached(type: UserCacheEntity?): UserEntity? {
        return type?.let {
            UserEntity(
                username = it.username
            )
        }
    }

    override fun mapToCached(type: UserEntity?): UserCacheEntity? {
        return type?.let {
            UserCacheEntity(
                username = it.username
            )
        }
    }
}
