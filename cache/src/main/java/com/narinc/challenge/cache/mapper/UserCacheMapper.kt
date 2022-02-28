package com.narinc.challenge.cache.mapper

import com.narinc.challenge.cache.models.UserCacheEntity
import com.narinc.challenge.data.models.UserEntity
import javax.inject.Inject

class UserCacheMapper @Inject constructor() : CacheMapper<UserCacheEntity, UserEntity> {
    override fun mapFromCached(type: UserCacheEntity): UserEntity {
        return UserEntity(
            username = type.username
        )
    }

    override fun mapToCached(type: UserEntity): UserCacheEntity {
        return UserCacheEntity(
            username = type.username
        )
    }
}
